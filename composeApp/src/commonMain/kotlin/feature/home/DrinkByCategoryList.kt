package feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrinkByCategoryListHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF1E2742),
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }

}

@OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@Composable
fun DrinkItemContent(
    cocktailVO: CocktailVO,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {},
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Image(
                    painter = rememberImagePainter(
                        url = cocktailVO.cocktailThumbnail
                    ),
                    contentDescription = "logo",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    painter = painterResource("ic_favorite.xml"),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Text(
                text = cocktailVO.cocktailName,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}
