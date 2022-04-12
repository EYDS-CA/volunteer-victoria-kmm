package com.fw.vvc.android.ui.screens

import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.fw.vvc.android.R
import com.fw.vvc.android.ui.navigation.NavigationActions
import com.fw.vvc.android.ui.viewmodels.SplashViewModel


@Composable
fun SplashScreen(
    navController: NavHostController
) {
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }
    val animation: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }

    val viewModel = hiltViewModel<SplashViewModel>()

    AnimationSplashContent(
        animation = animation,
        navigationActions = navigationActions,
        viewModel = viewModel
    )
    
    SplashImage(
        animation = animation
    )
}

@Composable
private fun AnimationSplashContent(
    animation: Animatable<Float, AnimationVector1D>,
    navigationActions: NavigationActions,
    viewModel: SplashViewModel
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        animation.animateTo(
            targetValue = 1F,
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )

        if (viewModel.isSessionActive.value == true) {
            Toast.makeText(context, "Welcome", Toast.LENGTH_LONG).show()
            navigationActions.navigateToHome.invoke()
        } else {
            navigationActions.navigateToLogin.invoke()
        }

    }
}

@Composable
private fun SplashImage(animation: Animatable<Float, AnimationVector1D>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_vvc_logo),
            contentDescription = "content description",
            modifier = Modifier
                .padding(horizontal = 100.dp)
                .alpha(animation.value)
        )
    }
}