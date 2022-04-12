package com.fw.vvc.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fw.vvc.android.ui.screens.*

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Splash.route
    ) {
        composable(Destinations.Splash.route) {
            SplashScreen(navController)
        }
        composable(Destinations.Login.route) {
            LoginScreen(navController)
        }
        composable(Destinations.Home.route) {
            HomeScreen(navController)
        }
        composable(Destinations.Detail.route) {
            OpportunityDetailsScreen(navController)
        }
        composable(Destinations.ExpressInterest.route) {
            ExpressInterestScreen(navController)
        }
        composable(Destinations.CreateOpportunity.route) {
            CreateOpportunityScreen(navController)
        }
        composable(Destinations.VolunteersList.route) {
            VolunteerListScreen(navController)
        }
    }
}