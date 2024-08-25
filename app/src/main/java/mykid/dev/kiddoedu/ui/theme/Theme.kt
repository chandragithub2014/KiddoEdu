package mykid.dev.kiddoedu.ui.theme

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat




private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun KiddoEduTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current


   /* MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )*/

    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb() //Color.Red.toArgb() //
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val hexColor = String.format("#%08X", colorScheme.primary.toArgb())
        Log.d("Theme", "Setting status bar color to (hex): $hexColor")
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
   /* SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Color.Red.toArgb() //colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val hexColor = String.format("#%08X", colorScheme.primary.toArgb())
        Log.d("Theme", "Setting status bar color to (hex): $hexColor")
    }*/

}

/*

To change Status bar color :
Explanation:
SideEffect: Ensures this code is executed when the theme is applied.
val window = (view.context as Activity).window: Obtains the current window.
window.statusBarColor = colorScheme.primary.toArgb(): Sets the status bar color to the primary color of your theme.
WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme: Configures the status bar content (icons, text) to be light or dark based on the current theme.

 */


//https://rivaldy.medium.com/changing-the-status-bar-color-in-jetpack-compose-a88d2778bc89


//https://stackoverflow.com/questions/76227584/jetpack-compose-theme-color-not-applied
/*
val colorScheme = when {
    darkTheme -> darkColorScheme
    else -> lightColorScheme
}
 */


/*
--------------------------------------------------------------------------
--------------------------------------------------------------------------
Other Info
--------------------------------------------------------------------------
--------------------------------------------------------------------------
Theming in Compose:
The official documentation on theming in Compose provides a good foundation for understanding how to create and apply themes, including color schemes: https://developer.android. com/ jetpack/ compose/ themes
Material 3 Theming:
The Material 3 documentation touches upon theming concepts and how to use Material 3 color schemes: https://m3.material. io/ styles/ color/ the- color- system/ color- roles
System UI Controller:
The documentation for SystemUiController in the Material library explains how to control system UI elements, including the status bar: https://developer.android. com/ reference/ kotlin/ androidx/ compose/ material/ SystemUiController
WindowInsets and Edge-to-Edge:
For more advanced scenarios involving edge-to-edge layouts and handling insets, the documentation on WindowInsets is helpful: https://developer.android. com/ reference/ kotlin/ androidx/ core/ view/ WindowInsetsCompat
Community Resources:
As you've experienced, platforms like Stack Overflow and Medium often have valuable discussions and code examples from developers who have tackled similar challenges.

 */