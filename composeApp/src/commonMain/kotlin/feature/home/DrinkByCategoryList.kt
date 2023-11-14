package feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@Composable
fun DrinkByCategoryList(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Random Drink",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF1E2742),
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
//        Card(
//            onClick = { },
//            shape = RoundedCornerShape(8.dp),
//            border = BorderStroke(1.dp, Color(0xFFFA3C49)),
//        ) {
//            Text(
//                text = "See All",
//                style = TextStyle(
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight(600),
//                    color = Color(0xFFFA3C49),
//                ),
//                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
//                    .align(Alignment.CenterVertically)
//            )
//        }
    }

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
            append("Blue")
        }
        append("  ")
        withStyle(style = SpanStyle(color = Color.White.copy(0.5F))) {
            append("Moon")
        }
    }

    Card(
        onClick = {},
        modifier = modifier.fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = Color(0xFFFA3C49),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    annotatedString,
                    fontWeight = FontWeight.Bold,
                    fontSize = 46.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                        .weight(1F)
                )
                Image(
                    painterResource("compose-multiplatform.xml"),
                    contentDescription = "Blue Moon",
                    modifier = Modifier.padding(8.dp)
                        .weight(1F)
                        .border(1.dp, Color.White, RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                Modifier.fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                Column(
                    Modifier.align(Alignment.TopStart),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(Modifier.wrapContentWidth()) {
                        Image(
                            painterResource("ic_glass.xml"),
                            contentDescription = "glass icon",
                            modifier = Modifier.padding(horizontal = 8.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "Mocktail",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Row(Modifier.wrapContentWidth()) {
                        Image(
                            painterResource("ic_timer.xml"),
                            contentDescription = "timer icon",
                            modifier = Modifier.padding(horizontal = 8.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "20 min",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Row(Modifier.wrapContentWidth()) {
                        Image(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            contentDescription = "timer icon",
                            modifier = Modifier.padding(horizontal = 8.dp)
                                .align(Alignment.CenterVertically),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Text(
                            text = "534",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }
                Column(
                    Modifier.align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "Easy",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        textAlign = TextAlign.End
                    )
                    Row(
                        Modifier.align(Alignment.End)
                            .padding(top = 16.dp)
                    ) {
                        repeat(5) {
                            Image(
                                painter = painterResource("ic_fire.xml"),
                                contentDescription = "favorite",
                                colorFilter = ColorFilter.tint(Color.Yellow),
                            )
                        }
                    }
                }
            }
        }
    }
}
