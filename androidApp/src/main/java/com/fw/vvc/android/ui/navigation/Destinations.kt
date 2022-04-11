package com.fw.vvc.android.ui.navigation
sealed class Destinations(val route: String) {

    object Splash: Destinations("splash")
    object Login: Destinations("login")
    object Home: Destinations("home")

    fun routeWithParams(vararg params: String): String {
        return route + params.map {
            "/{$it}"
        }
    }

}