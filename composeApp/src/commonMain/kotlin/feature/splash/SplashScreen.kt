package feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import feature.BasicNavigationScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(1F)
        ) {
            Column {
                Text(
                    text = "It's a time for",
                    fontSize = TextUnit(value = 24F, type = TextUnitType.Sp)
                )
                Text(
                    text = "Drink",
                    fontSize = TextUnit(value = 70F, type = TextUnitType.Sp),
                    color = Color(0xFFE63946)
                )
                Text(
                    text = "The one-stop to find amazing drink mixes for any occassion.",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                    color = MaterialTheme.colors.onSecondary
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(1F)
        ) {
            Image(
                painter = painterResource("ic_drink.xml"),
                contentDescription = "Splash Image",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(0.6F)
        ) {
            Button(
                onClick = {
                    navigator.push(
                        BasicNavigationScreen(1)
                    )
                },
                modifier = Modifier
                    .width(180.dp)
                    .height(58.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFE63946),
                    contentColor = Color(0xFFE63946)
                )
            ) {
                Row(
                    Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                    Image(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = "Arrow Right",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }
    }
}
