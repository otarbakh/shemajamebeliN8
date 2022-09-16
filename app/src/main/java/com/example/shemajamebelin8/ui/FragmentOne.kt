package com.example.shemajamebelin8.ui


import android.util.Log.d

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager

import com.example.shemajamebelin8.BaseFragment
import com.example.shemajamebelin8.Resource
import com.example.shemajamebelin8.adapters.SuitsAdapter

import com.example.shemajamebelin8.databinding.FragmentFragmentOneBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentOne : BaseFragment<FragmentFragmentOneBinding>(FragmentFragmentOneBinding::inflate) {

    private val suitsAdapter: SuitsAdapter by lazy { SuitsAdapter() }
    val fragmentOneViewModel:FragmentOneViewModel by viewModels()

    override fun viewCreated() {
        observe()
    }

    override fun listeners() {

    }

    private fun observe() {
        setupRecycler()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                fragmentOneViewModel.state.collectLatest {
                    when (it) {
                        is Resource.Error -> {
                            d("tag","error")
                        }
                        is Resource.Loading -> {
                            d("tag","loading")
                        }
                        is Resource.Success -> {
                            suitsAdapter.submitList(it.data)
                            d("tag",it.data.toString())

                        }
                    }
                }
            }
        }
    }

    private fun setupRecycler() {
        binding.rvItems.apply {
            adapter = suitsAdapter
            layoutManager =
                GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
        }
    }

}