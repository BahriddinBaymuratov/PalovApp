package com.example.palov.ui.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.base.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: AllUseCases
) : ViewModel(){
    private val _userState : MutableState<Boolean> = mutableStateOf(false)
    val userState: State<Boolean> get() = _userState

    init {
        viewModelScope.launch {
            useCase.getUserVisitingUseCase.invoke(Unit).collectLatest {
                _userState.value = it
            }
        }
    }
    fun saveUserVisiting(boolean: Boolean){
        viewModelScope.launch {
            useCase.saveUserVisitingUseCase(boolean)
        }
    }

}