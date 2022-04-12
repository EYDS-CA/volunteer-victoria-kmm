package com.fw.vvc.android.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavigationActions(navController: NavHostController) {
    val navigateToLogin: () -> Unit = {
        navController.navigate(Destinations.Login.route) {
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(Destinations.Home.route) {
            launchSingleTop = true
            restoreState = true
            navController.graph.setStartDestination(Destinations.Home.route)
        }
    }

    val navigateToDetail: () -> Unit = {
        navController.navigate(Destinations.Detail.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
        }
    }

    val navigateToExpressInterest: () -> Unit = {
        navController.navigate(Destinations.ExpressInterest.route)
    }

    val navigateToCreateOpportunity: () -> Unit = {
        navController.navigate(Destinations.CreateOpportunity.route)
    }

    val navigateToVolunteersList: () -> Unit = {
        navController.navigate(Destinations.VolunteersList.route)
    }

    val popBack: () -> Unit = {
        navController.popBackStack()
    }
}