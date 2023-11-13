package feature.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeCategories(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Categories",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF1E2742),
            )
        )
        Box(
            modifier = Modifier
                .shadow(elevation = 15.dp, spotColor = Color(0x33FCBABA), ambientColor = Color(0x33FCBABA))
                .border(width = 1.dp, color = Color(0x40FB7D8A), shape = RoundedCornerShape(size = 8.dp))
                .padding(8.dp)
        ){
            Text(
                text = "See All",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 34.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFA3C49),
                )
            )
        }
    }
}
