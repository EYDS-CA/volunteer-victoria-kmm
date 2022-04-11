package com.fw.vvc.android.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.facebook.AccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _isSessionActive = MutableLiveData<Boolean>()
    val isSessionActive: LiveData<Boolean> = _isSessionActive

    init {
        fetchSession()
    }

    private fun fetchSession() {
        val accessToken = AccessToken.getCurrentAccessToken()
        _isSessionActive.value = accessToken != null && !accessToken.isExpired
    }
}