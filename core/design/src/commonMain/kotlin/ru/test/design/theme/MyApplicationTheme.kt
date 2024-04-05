package ru.test.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Light default theme color scheme
 */

val LightDefaultColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Black,
    primaryContainer = InchWorm,
    onPrimaryContainer = Black,
    secondary = BrightGrey,
    onSecondary = Color.White,
    secondaryContainer = NightRider,
    onSecondaryContainer = Color.White,
    tertiary = Blue40,
    onTertiary = Color.White,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Color.White,
    onBackground = Black,
    surface = Color.White,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    inverseSurface = DarkPurpleGray20,
    inverseOnSurface = DarkPurpleGray95,
    outline = Gainsboro
)

/**
 * Dark default theme color scheme
 */

val DarkDefaultColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Black,
    primaryContainer = InchWorm,
    onPrimaryContainer = Black,
    secondary = BrightGrey,
    onSecondary = Color.White,
    secondaryContainer = NightRider,
    onSecondaryContainer = Color.White,
    tertiary = Blue40,
    onTertiary = Color.White,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Color.White,
    onBackground = Black,
    surface = Color.White,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    inverseSurface = DarkPurpleGray20,
    inverseOnSurface = DarkPurpleGray95,
    outline = Gainsboro
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        LightDefaultColorScheme
    } else {
        DarkDefaultColorScheme
    }
    val typography = TestTypography

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(8.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}