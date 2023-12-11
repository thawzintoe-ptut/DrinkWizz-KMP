package di

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.screenModule
import feature.home.HomeScreen
import feature.splash.SplashScreen

sealed class DrinkWizzScreen : ScreenProvider {
    data object SplashScreen : DrinkWizzScreen()
    data object Home : DrinkWizzScreen()
}

val drinkWizzScreenModule = screenModule {
    register<DrinkWizzScreen.SplashScreen> {
        SplashScreen()
    }
    register<DrinkWizzScreen.Home> {
        HomeScreen()
    }
}
