package com.fw.vvc.android.ui.screens

import androidx.activity.result.ActivityResultRegistryOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.navigation.NavigationActions
import com.fw.vvc.android.ui.theme.Typography
import com.fw.vvc.android.ui.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }

    val context = LocalContext.current
    val viewModel = hiltViewModel<LoginViewModel>()

    val successState by viewModel.successLiveData.observeAsState(null)

    successState?.let {
        navigationActions.navigateToHome.invoke()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Sign In with Facebook",
                style = Typography.h5,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "We use Facebook sign in to make signing into our community fast and secure.",
                style = Typography.body1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    disabledBackgroundColor = Color.Blue,
                    disabledContentColor = Color.Blue
                ),
                content = {
                    Text(text = "Continue with fb")
                },
                onClick = {
                    val resultCallback = context as ActivityResultRegistryOwner
                    viewModel.executeLogin(resultCallback)
                }
            )
        }
    }
}