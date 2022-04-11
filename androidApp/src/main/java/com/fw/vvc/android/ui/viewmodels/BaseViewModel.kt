package com.fw.vvc.android.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun showLoader() {
        _isLoading.value = true
    }

    fun hideLoader() {
        _isLoading.value = false
    }

    fun showError(exception: Exception) {
        _error.value = exception
    }

    fun <T> executeJob(
        job: suspend () -> T,
        onSuccess: (T) -> Unit = {},
        onError: (Exception) -> Unit = ::showError
    ) {
        viewModelScope.launch {
            kotlin.runCatching {
                job.invoke()
            }.onSuccess(onSuccess)
            .onFailure{
                it.printStackTrace()
                onError.invoke(Exception(it))
            }
        }
    }

}