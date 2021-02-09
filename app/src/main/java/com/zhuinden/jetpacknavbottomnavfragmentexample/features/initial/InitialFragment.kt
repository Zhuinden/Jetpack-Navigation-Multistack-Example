package com.zhuinden.jetpacknavbottomnavfragmentexample.features.initial

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.jetpacknavbottomnavfragmentexample.R
import com.zhuinden.jetpacknavbottomnavfragmentexample.databinding.InitialFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InitialFragment: Fragment(R.layout.initial_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = InitialFragmentBinding.bind(view)

        binding.buttonInitialGoToNext.setOnClickListener {
            findNavController().navigate(R.id.initial_to_root)
        }
    }
}