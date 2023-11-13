package feature

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import feature.home.HomeScreenContent
import feature.splash.SplashScreenContent

class BasicNavigationScreen(
    val index: Int,
    val wrapContent: Boolean = false
) : Screen {

    override val key = uniqueScreenKey

    @Composable
    override fun Content() {
        if (index == 0) {
            SplashScreenContent()
        }
        if (index == 1) {
            HomeScreenContent()
        }
    }
}
