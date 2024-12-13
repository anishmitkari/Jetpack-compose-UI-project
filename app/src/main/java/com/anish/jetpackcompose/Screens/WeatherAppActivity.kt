package com.anish.jetpackcompose.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anish.jetpackcompose.R
import com.anish.jetpackcompose.data.Futuremodel
import com.anish.jetpackcompose.data.HourlyModel

class WeatherAppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherScreen()
        }
    }

}

@Preview
@Composable
fun WeatherScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#59469d")),
                        Color(android.graphics.Color.parseColor("#643d67"))
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "Mostly Cloudy",
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 48.dp),
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.cloudy),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 8.dp)
                    )

//Display date and time
                    Text(
                        text = "Mon June 17 | 10:00 AM",
                        fontSize = 19.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center

                    )
//Display temperature
                    Text(
                        text = "25",
                        fontSize = 63.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center

                    )
                    Text(
                        text = "H:27 L:18",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center

                    )

//                    Box Containing weather details like rain, wind speed, humidity

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .background(
                                color = colorResource(
                                    id = R.color.purple,
                                ), shape = RoundedCornerShape(25.dp)
                            )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            WeatherDetailItem(icon = R.drawable.rain, value = "22%", label = "Rain")
                            WeatherDetailItem(icon = R.drawable.wind, value = "22%", label = "Wind")
                            WeatherDetailItem(
                                icon = R.drawable.humidity, value = "18%", label = "Humidity"
                            )


                        }
                    }
                    //Displaying todays label

                    Text(
                        text = "Today",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp)
                    )

                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(items) { item ->
                            FutureModelViewHolder(item)
                        }


                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Future",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Next 7 days",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


                items(DAILYitems){
                    FutureitemItem(item = it)
                }
            }


        }

    }


}

//Viewholder  for each hourly forecast
@Composable
fun FutureModelViewHolder(model: HourlyModel) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .wrapContentHeight()
            .padding(4.dp)
            .background(
                color = colorResource(id = R.color.purple), shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            text = model.HOUR,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "${model.TEMP}",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(
                id = when (model.PICPATH) {
                    "cloudy" -> R.drawable.cloudy
                    "sunny" -> R.drawable.sunny
                    "wind" -> R.drawable.wind
                    "rainy" -> R.drawable.rain
                    else -> R.drawable.wind
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

    }

}


@Composable
fun WeatherDetailItem(icon: Int, value: String, label: String) {
    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(34.dp)
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
        Text(text = label, color = colorResource(id = R.color.white), textAlign = TextAlign.Center)
    }
}

//Display each future daily forecast item
@Composable
fun FutureitemItem(item: Futuremodel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.day,
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),

            )

        Image(
            painter = painterResource(id = getDrawableResourceId(picPath = item.picPath)),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .padding(start = 32.dp)
                .size(45.dp)
        )
        Text(
            text = item.status,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),

            )
        Text(
            text = "${item.highTemp}",
            modifier = Modifier.padding(end = 16.dp) ,
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),

            )
        Text(
            text = "${item.lowTemp}",
            modifier = Modifier.padding(end = 16.dp) ,
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),

            )
    }
}

@Composable
fun getDrawableResourceId(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "windy" -> R.drawable.windy
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "sunny" -> R.drawable.sunny
        "rainy" -> R.drawable.rainy
        else -> R.drawable.rain
    }

}

// sample data for hourly show
val items = listOf(
    HourlyModel("9 pm", 25, "cloudy"),
    HourlyModel("10 pm", 28, "sunny"),
    HourlyModel("11 pm", 30, "wind"),
    HourlyModel("12 pm", 28, "rainy")
)

// SAMPLE DAILY DATA
val DAILYitems = listOf(
    Futuremodel("Sat", "storm", "Storm", 25, 16),
    Futuremodel("Sun", "cloudy", "cloudy", 25, 16),
    Futuremodel("Mon", "windy", "windy", 25, 16),
    Futuremodel("Tue", "cloudy_sunny", "cloudy_sunny", 25, 16),
    Futuremodel("Wed", "sunny", "sunny", 25, 16),
    Futuremodel("Thu", "rainy", "rainy", 25, 16)

)