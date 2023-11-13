package feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize()
    ) {
        item { HomeHeaderTopAppbar() }
        item {
            HomeHeaderContent(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
        item {
            HomeCategories(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeHeaderTopAppbar() {
    TopAppBar(
        title = {
            Box(
                Modifier.fillMaxSize()
                    .padding(end = 56.dp)
            ) {
                Image(
                    painterResource("ic_drinkWizLogo.xml"),
                    contentDescription = "logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Image(
                    painter = painterResource("ic_menu.xml"),
                    contentDescription = "Menu"
                )
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeHeaderContent(
    modifier: Modifier
) {
    Text(
        "I want to learn...",
        color = Color(0xFF1E2742),
        fontSize = TextUnit(24F, TextUnitType.Sp),
        modifier = modifier.padding(top = 24.dp),
        fontWeight = FontWeight.Bold
    )
    Card(
        onClick = { /* doSomething() */ },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Search",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF1E2742)
                ),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
            Image(
                imageVector = Icons.Rounded.Search,
                contentDescription = "image description",
                contentScale = ContentScale.None,
                modifier = Modifier.fillMaxHeight()
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
