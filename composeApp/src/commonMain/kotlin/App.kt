import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.screenModule
import cafe.adriel.voyager.navigator.Navigator
import di.appModule
import di.drinkWizzScreenModule
import feature.splash.SplashScreen
import org.koin.compose.KoinApplication

@Composable
fun App() {
    ScreenRegistry {
        screenModule { drinkWizzScreenModule }
    }
    KoinApplication(application = {
        modules(appModule)
    }) {
        DrinkWizzScreen()
    }
}

@Composable
fun DrinkWizzScreen() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Navigator(screen = SplashScreen())
        }
    }
}
