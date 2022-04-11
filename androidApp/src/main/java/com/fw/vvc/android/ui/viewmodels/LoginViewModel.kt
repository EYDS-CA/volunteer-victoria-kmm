package com.fw.vvc.android.ui.viewmodels

import android.os.Bundle
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.fw.vvc.android.ui.models.FacebookCancelRequestException
import com.fw.vvc.android.ui.models.FacebookErrorRequestException
import com.fw.vvc.interactor.session.LoginInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
): BaseViewModel() {

    private val _successLiveData = MutableLiveData<Unit>()
    val successLiveData: LiveData<Unit> = _successLiveData

    private val facebookCallback = object : FacebookCallback<LoginResult> {
        override fun onSuccess(result: LoginResult) {
            executeGraphRequest(result.accessToken)
        }

        override fun onError(error: FacebookException) {
            error.printStackTrace()
            showError(FacebookErrorRequestException(error.message.orEmpty()))
        }

        override fun onCancel() {
            showError(FacebookCancelRequestException())
        }
    }

    private fun saveSession(fbId: String, name: String, avatar: String) {
        executeJob(
            job = {
                loginInteractor.execute(fbId = fbId, name = name, avatar = avatar)
            },
            onSuccess = _successLiveData::setValue
        )
    }

    private fun executeGraphRequest(accessToken: AccessToken) {
        val request = GraphRequest.newMeRequest(accessToken) { jsonObject, response ->
            if (response != null && jsonObject != null && response.error == null) {
                val fbId = accessToken.userId
                val name = jsonObject.getString("name")
                val avatar = jsonObject.getJSONObject("picture").getJSONObject("data").getString("url")

                saveSession(fbId = fbId, name = name, avatar = avatar)
            }
        }

        with(request) {
            parameters =  Bundle().apply {
                putString("fields", GRAPH_API_PARAMETERS)
            }
            executeAsync()
        }
    }

    fun executeLogin(activityResultRegistryOwner: ActivityResultRegistryOwner) {
        val callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(
            callbackManager,
            facebookCallback
        )

        LoginManager.getInstance().logInWithReadPermissions(
            activityResultRegistryOwner,
            callbackManager,
            listOf(FACEBOOK_PUBLIC_PROFILE_PERMISSION)
        )
    }

    companion object {
        private const val FACEBOOK_PUBLIC_PROFILE_PERMISSION = "public_profile"
        private const val GRAPH_API_PARAMETERS = "id,name,picture"
    }

}