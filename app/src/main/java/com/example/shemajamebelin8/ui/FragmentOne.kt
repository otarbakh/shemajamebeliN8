package com.example.shemajamebelin8.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.Resource
import com.example.shemajamebelin8.BaseFragment
import com.example.shemajamebelin8.databinding.ActivityMainBinding.inflate
import com.example.shoppingapp.Adapters.ShmotkebiAdapter
import com.example.test.BaseFragment
import com.example.test.R
import com.example.test.Resource
import com.example.test.databinding.FragmentFragmentOneBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentOne : BaseFragment<FragmentFragmentOneBinding>(FragmentFragmentOneBinding::inflate) {

    private val shmotkebiAdapter: ShmotkebiAdapter by lazy { ShmotkebiAdapter() }
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
                            shmotkebiAdapter.submitList(it.data)
                            d("tag",it.data.toString())

                        }
                    }
                }
            }
        }
    }

    private fun setupRecycler() {
        binding.rvItems.apply {
            adapter = shmotkebiAdapter
            layoutManager =
                GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
        }
    }

}