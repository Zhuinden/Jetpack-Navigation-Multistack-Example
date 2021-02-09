package com.zhuinden.jetpacknavbottomnavfragmentexample.core.navigation

import android.os.Bundle
import android.view.View
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.zhuinden.jetpacknavbottomnavfragmentexample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentStackHostFragment : Fragment(R.layout.stack_host_fragment) {
    companion object {
        fun newInstance(@NavigationRes navigationId: Int): FragmentStackHostFragment = FragmentStackHostFragment().apply {
            arguments = Bundle().also { bundle ->
                bundle.putInt("navigationId", navigationId)
            }
        }
    }

    lateinit var navController: NavController
        private set

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(childFragmentManager.findFragmentById(R.id.containerStackHost) as NavHostFragment)
        this.navController = navController

        val hasGraph = try {
            navController.graph
            true
        } catch (e: IllegalStateException) {
            false
        }

        if (!hasGraph) {
            navController.setGraph(requireArguments().getInt("navigationId"))
        }
    }
}