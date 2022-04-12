package com.fw.vvc.android.ui.navigation
sealed class Destinations(val route: String) {

    object Splash: Destinations("splash")
    object Login: Destinations("login")
    object Home: Destinations("home")
    object Detail: Destinations("detail")
    object ExpressInterest: Destinations("expressInterest")
    object CreateOpportunity: Destinations("createOpportunity")
    object VolunteersList: Destinations("VolunteersList")

}