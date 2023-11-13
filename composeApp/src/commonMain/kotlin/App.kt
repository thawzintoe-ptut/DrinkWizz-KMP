import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import feature.BasicNavigationScreen

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Navigator(
                screen = BasicNavigationScreen(0),
                onBackPressed = { current ->
                    true
                }
            ) { navigator ->
                Scaffold(
                    content = { CurrentScreen() },
                )
            }
        }
    }
}
