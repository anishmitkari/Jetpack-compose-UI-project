package com.anish.jetpackcompose.Furniture.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.anish.jetpackcompose.Furniture.Common.SpacerHeight
import com.anish.jetpackcompose.Furniture.Common.SpacerWidth
import com.anish.jetpackcompose.Furniture.Navigation.ProductDetail
import com.anish.jetpackcompose.R
import com.anish.jetpackcompose.ui.theme.DarkOrange
import com.anish.jetpackcompose.ui.theme.LightGray
import com.anish.jetpackcompose.ui.theme.LightGray_1
import com.anish.jetpackcompose.ui.theme.TextColor_1
import com.nameisjayant.projects.furniture.data.Category
import com.nameisjayant.projects.furniture.data.PopularProducts
import com.nameisjayant.projects.furniture.data.Rooms
import com.nameisjayant.projects.furniture.data.categoryList
import com.nameisjayant.projects.furniture.data.popularProductList
import com.nameisjayant.projects.furniture.data.roomList

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    var text by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(29.dp)
            .background(Color.White)
    ) {
        item {

            Header()
            CustomTextField(text = text, onValueChange = { text = it })
            SpacerHeight(20.dp)
            CategoryRow()
            SpacerHeight(20.dp)
            PopularRow{ navHostController.navigate(ProductDetail) }
            BannerRow()
            RoomsTitles()

        }

    }
}


// Header top
@Composable
fun Header(onClick: () -> Unit = {}) {

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.heading_text),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.W600, color = Color.Black)
        )
        IconButton(onClick = onClick, modifier = Modifier.size(32.dp)) {

            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }

    }
}

// Search field
@Composable
fun CustomTextField(text: String, modifier: Modifier = Modifier, onValueChange: (String) -> Unit) {

    TextField(value = text,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(

            unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent
        ),

        placeholder = {
            Text(
                text = stringResource(id = R.string.placeholder), style = TextStyle(
                    fontSize = 15.sp, fontWeight = FontWeight.W600, color = LightGray
                )
            )
        },
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "",
                tint = LightGray_1
            )
        },
        modifier = modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .border(2.dp, LightGray_1, RoundedCornerShape(8.dp)),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )
}

// Category section
@Composable
fun CategoryRow() {
    Column {

        CommonTitle(title = stringResource(id = R.string.categories))
        SpacerHeight(20.dp)
        LazyRow { items(categoryList, key = { it.id }) { CategoryEachRow(category = it) } }

    }
}
//Category section item view
@Composable
fun CategoryEachRow(category: Category) {
    Box(
        modifier = Modifier
            .padding(start = 15.dp)
            .background(category.color, RoundedCornerShape(8.dp))
            .width(140.dp)
            .height(80.dp)
    ) {
        Text(
            text = category.title,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.W400, color = Color.Black),
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterStart)
        )

        Image(
            painter = painterResource(id = category.image),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(end = 5.dp)
                .align(Alignment.BottomEnd)
        )
    }


}


// Common title Categories Popular with see all arrow and text in orange
@Composable
fun CommonTitle(title: String, onClick: () -> Unit = {}) {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = title,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W600, color = Color.Black)
        )

        TextButton(onClick = onClick) {
            Text(
                text = stringResource(id = R.string.see_all),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = DarkOrange
                )

            )

            SpacerWidth(3.dp)

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "",
                tint = DarkOrange,
                modifier = Modifier.size(20.dp)
            )

        }
    }

}

//popular  section

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularRow(onClick: () -> Unit) {
    Column {
        CommonTitle(title = stringResource(id = R.string.popular))
        SpacerHeight()
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            popularProductList.forEach {
                PopularEachRow(data = it) { onClick()}
            }
        }
    }
}
// Popular section item view
@Composable
fun PopularEachRow(
    data: PopularProducts, modifier: Modifier = Modifier, onClick: () -> Unit
) {
    Column(modifier = modifier
        .padding(vertical = 5.dp)
        .clickable { onClick ()}) {
        Box {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = "",
                modifier = Modifier
                    .width(141.dp)
                    .height(149.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.wishlist),
                contentDescription = "",
                modifier = Modifier
                    .padding(20.dp)
                    .size(32.dp)
                    .align(Alignment.TopEnd),
                tint = Color.Unspecified
            )
        }

        SpacerHeight()
        ElevatedCard(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {

                Text(
                    text = data.title,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.LightGray
                    )
                )
                Text(
                    text = data.price,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.Black
                    )
                )

            }
        }
    }
}

//Bannner
@Composable
fun BannerRow() {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "",
        modifier = Modifier
            .padding(vertical = 20.dp)
            .clip(
                RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .height(113.dp),
        contentScale = ContentScale.FillWidth
    )
}

// Rooms section

@Composable
fun RoomsTitles() {
    Column {
        Text(
            text = stringResource(id = R.string.rooms),
            style = TextStyle(fontWeight = FontWeight.W600),
            fontSize = 20.sp,
            color = Color.Black
        )
        SpacerHeight(5.dp)
        Text(
            text = stringResource(id = R.string.room_des),
            style = TextStyle(fontWeight = FontWeight.W400),
            fontSize = 20.sp,
            color = Color.Black
        )
        SpacerHeight()
//        list for rooms section
        LazyRow {
            items(roomList, key = { it.id }) {
                Roomsection(rooms = it)
            }
        }
    }
}


//rooms section itemview
@Composable
fun Roomsection(rooms: Rooms) {

    Box(modifier = Modifier.padding(end = 15.dp)) {

        Image(
            painter = painterResource(id = rooms.image),
            contentDescription = "",
            modifier = Modifier
                .width(127.dp)
                .height(195.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
        )
        Text(
            text = rooms.title,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.W600, color = TextColor_1),
            modifier = Modifier
                .width(100.dp)
                .padding(20.dp)
        )

    }

}





