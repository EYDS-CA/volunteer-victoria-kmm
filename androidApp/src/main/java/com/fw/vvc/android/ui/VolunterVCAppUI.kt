package com.fw.vvc.android.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fw.vvc.android.ui.navigation.AppNavigation
import com.fw.vvc.android.ui.theme.Theme

@Composable
fun VolunteerVCAppUI() {
    Theme {
        val navController = rememberNavController()

        Scaffold (
            content = {
                AppNavigation(
                    navController = navController
                )
            }
        )
    }
}