package com.anish.jetpackcompose.Codetutor

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anish.jetpackcompose.Codetutor.Components.circletext


@Composable
fun Countrycard(countryInfo: CountryInfo) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .padding(10.dp)
            .wrapContentHeight(align = Alignment.Top)
            .border(1.dp, color = Color.LightGray),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .weight(0.2f)
            ) {

                Box(
                    modifier = Modifier

                        .width(70.dp)
                        .height(50.dp)
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val imgresource = countryInfo.flagId
                    val imgpainter: Painter = painterResource(id = imgresource)
                    Image(
                        painter = imgpainter,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                }

                Text(
                    text = countryInfo.commonName,
                    modifier = Modifier
                        .fillMaxWidth(1.0f)
                        .padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.officialName,
                    modifier = Modifier
                        .fillMaxWidth(1.0f)
                        .padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .weight(0.8f)
            ) {
                Text(
                    text = countryInfo.nationalCapital,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(1.0f)
                )
                Text(
                    text = countryInfo.subRegion,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(1.0f)
                )
                Text(
                    text = countryInfo.region,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth(1.0f)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    circletext(countryInfo.currencyName)

                    Text(
                        text = "91",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth(0.4f)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(0.3f)

                    ) {

                        Text(
                            text = countryInfo.mobileCode,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)

                        )
                        Text(
                            text = countryInfo.nationalCapital,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)

                        )
                    }
                }
            }
        }
    }


}

