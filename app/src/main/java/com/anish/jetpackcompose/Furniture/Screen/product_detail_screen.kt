package com.anish.jetpackcompose.Furniture.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.anish.jetpackcompose.Furniture.Common.SpacerHeight
import com.anish.jetpackcompose.Furniture.Common.SpacerWidth
import com.anish.jetpackcompose.R
import com.anish.jetpackcompose.ui.theme.Background
import com.anish.jetpackcompose.ui.theme.DarkOrange
import com.anish.jetpackcompose.ui.theme.LightGray_1
import com.anish.jetpackcompose.ui.theme.TextColor_1

@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    val chips = listOf("Description","Material","Review")
    var selected by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.product_four),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillWidth
        )

        HeaderSection { navHostController.navigateUp() }
    }

//white section create after image curve
    Box(
        modifier = Modifier
            .padding(top = 230.dp)
            .fillMaxSize()
            .background(
                Color.White, RoundedCornerShape(16.dp)
            )
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 70.dp)) {

            item {
                ProductHeadeerSection()
                Ratingrow()
            }
        }
    }
}

@Composable
fun HeaderSection(onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = onBack) {

            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = " ", tint = Color.Black)
        }
        Icon(
            painter = painterResource(R.drawable.share),
            contentDescription = " ",
            tint = Color.Unspecified
        )

    }
}

//    Product Title and price dollar pluz minus buttom

@Composable
fun ProductHeadeerSection() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.product_name),
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W600, color = DarkOrange)
        )
        SpacerHeight()
//            Dollar price line
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string._599), style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.W600, color = DarkOrange
                ), modifier = Modifier
                    .weight(1f)
                    .align(
                        CenterVertically
                    )
            )
//plus minus button and text
            ProductCountButton {
                if (count > 0) {
                    count--
                }
            }

            Text(text = "$count", modifier = Modifier.padding(horizontal = 10.dp))

            ProductCountButton {

                count++

            }

        }
    }
}

//product pls minus button
@Composable
fun ProductCountButton(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.size(35.dp),
        border = BorderStroke(
            2.dp, DarkOrange
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {

        Icon(Icons.Default.Add, contentDescription = "", tint = DarkOrange)
    }
}

//Rating row

@Composable
fun Ratingrow() {
    val personIcons = listOf(
        R.drawable.person_1, R.drawable.person_2, R.drawable.person_3, R.drawable.person_4
    )

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .background(
                Background, RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Column(modifier = Modifier.weight(1f)) {

                Row {
                    repeat(5) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }
                    SpacerWidth(5.dp)
                    Text(
                        text = "5.0", style = TextStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.W400, color = TextColor_1
                        ), modifier = Modifier.align(CenterVertically)
                    )

                }

                SpacerHeight()
                Row {
                    Text(
                        stringResource(R.string._98_reviews), style = TextStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.W400, color = TextColor_1
                        ), modifier = Modifier.align(CenterVertically)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier
                            .size(16.dp)
                            .align(CenterVertically),
                        tint = LightGray_1
                    )
                }
            }

            Row {
                personIcons.forEachIndexed { index, i ->
                    Icon(
                        painter = painterResource(id = i),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(32.dp)
                            .offset(
                                x = if (index == 1) -(10.dp) else if (index == 2) -(20.dp) else if (index == 3) -(30.dp) else 0.dp,
                                y = 0.dp
                            )
//                        offset for overlapping image one on one
                    )
                }

            }
        }


    }
}

@Composable
fun CustomChips(title:String,selected:Int,Index:Int,modifier:Modifier=Modifier,onValueChange:(Int) -> Unit){

}