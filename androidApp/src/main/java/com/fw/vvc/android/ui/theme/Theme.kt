package com.fw.vvc.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    onPrimary = Color.White,
    secondary = Secondary,
    secondaryVariant = Secondary,
    onSecondary = Color.Black,
    error = Red800,
    background = Background,
    onBackground = Color.Black,
    surface = Surface,
)

@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
