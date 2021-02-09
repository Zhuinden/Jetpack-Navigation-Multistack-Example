package com.zhuinden.jetpacknavbottomnavfragmentexample.features.root.first

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.zhuinden.jetpacknavbottomnavfragmentexample.R
import com.zhuinden.jetpacknavbottomnavfragmentexample.databinding.FirstFragment2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class First2Fragment : Fragment(R.layout.first_fragment_2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FirstFragment2Binding.bind(view)

        binding.buttonFirstFragment2GoBack.setOnClickListener {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }

        (requireActivity() as OnBackPressedDispatcherOwner).onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            NavHostFragment.findNavController(requireParentFragment()).popBackStack()
        }
    }
}