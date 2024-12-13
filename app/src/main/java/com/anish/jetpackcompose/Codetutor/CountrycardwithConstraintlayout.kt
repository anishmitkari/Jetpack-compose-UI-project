package com.anish.jetpackcompose.Codetutor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun CountrycardwithConstarintlayout(countryInfo: CountryInfo) {

    ConstraintLayout(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(2.dp)
    ) {

        val (flag,commonname,capital,officialname,region,subregion,currencysymbol,currencyname ) = createRefs()
        val imgresource = countryInfo.flagId
        val imgpainter: Painter = painterResource(id = imgresource)
var topGuideline = createGuidelineFromTop(0.1f)
var startguideline = createGuidelineFromStart(2.dp)
      Image(
            painter = imgpainter,
            contentDescription = "",
            contentScale = ContentScale.Crop,modifier= Modifier
                .fillMaxWidth(0.3f)
                .height(70.dp)
                .padding(2.dp)
                .constrainAs(flag) {
                    top.linkTo(topGuideline)
                    start.linkTo(startguideline)
                }
        )
        
        Text(text = countryInfo.commonName,modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .constrainAs(commonname) {
                top.linkTo(flag.bottom)
                start.linkTo(parent.start)
                end.linkTo(flag.end)
            }, fontSize = 20.sp, textAlign = TextAlign.Center)


        Text(text = countryInfo.nationalCapital,modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .constrainAs(capital) {
                start.linkTo(parent.start)
                top.linkTo(commonname.bottom)
                end.linkTo(flag.end)
            }, fontSize = 15.sp, textAlign = TextAlign.Center)

    }
}