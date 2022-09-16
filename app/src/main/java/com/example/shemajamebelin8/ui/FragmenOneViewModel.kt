package com.example.shemajamebelin8.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.shemajamebelin8.di.usecase.ShmotkebiUseCase
import com.example.shemajamebelin8.models.ShmotkebiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FragmentOneViewModel @Inject constructor(
    private val shmotkebiUseCase: ShmotkebiUseCase
) : ViewModel() {


    private val _state = MutableStateFlow<Resource<List<ShmotkebiResponse>>>(Resource.Loading(false))
    val state = _state.asSharedFlow()


    init {
        getYesOrNo()
    }

    private fun getYesOrNo() {
        shmotkebiUseCase().onEach { result ->
            when (result){
                is Resource.Success -> {
                    _state.value = Resource.Success(result.data)
                }
                is Resource.Error -> {
                    _state.value = Resource.Error("woops!")
                }
                is Resource.Loading -> {
                    _state.value = Resource.Loading(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}