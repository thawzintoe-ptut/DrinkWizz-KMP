package feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeCategories(
    modifier: Modifier = Modifier,
    rowListState: LazyListState
) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Categories",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1E2742),
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Card(
                onClick = { },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFFA3C49)),
            ) {
                Text(
                    text = "See All",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFA3C49),
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        LazyRow(
            state = rowListState,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(categoryList, key = { it.id }) { category ->
                DrinkCategoryItem(
                    name = category.name,
                    image = category.image
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@Composable
fun DrinkCategoryItem(
    modifier: Modifier = Modifier,
    name: String,
    image: String
) {
    Card(
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .padding(4.dp)
            .width(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                colorFilter = ColorFilter.tint(Color.Black),
            )
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
//            Text(
//                text = "50 mixes",
//                style = TextStyle(
//                    fontSize = 11.sp,
//                    fontWeight = FontWeight(600),
//                    color = Color.Black
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                textAlign = TextAlign.Center
//            )
        }
    }
}

val categoryList = listOf(
    DrinkCategory(
        id = 1L,
        name = "Cocktails",
        image = "ic_mocktail.xml"
    ),
    DrinkCategory(
        id = 2L,
        name = "Glass",
        image = "ic_glass.xml"
    ),
    DrinkCategory(
        id = 3L,
        name = "Ingredient",
        image = "ic_fire.xml"
    ),
    DrinkCategory(
        id = 4L,
        name = "filter",
        image = "ic_tea_glass.xml"
    )
)

@Immutable
data class DrinkCategory(
    val id: Long,
    val name: String,
    val image: String
)
