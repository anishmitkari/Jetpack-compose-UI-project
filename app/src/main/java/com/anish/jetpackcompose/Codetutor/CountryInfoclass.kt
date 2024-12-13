package com.anish.jetpackcompose.Codetutor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anish.jetpackcompose.R

class CountryInfoclass : ComponentActivity() {

    private val indiainfo = CountryInfo(R.drawable.three, "india",
        "delhi", "republic india", "Asia", "south asia",
        "₹", "rupiya", "+91", ".in"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Countrycard(countryInfo = indiainfo)

        }
    }
@Preview
@Composable
fun preview(){
    Surface(modifier = Modifier
        .fillMaxWidth(1.0f)
        .padding(5.dp)
        .border(1.dp, Color.LightGray)
        .wrapContentHeight(align = Alignment.Top)) {
//        CountrycardwithConstarintlayout(countryInfo = indiainfo)

//        Countrycard(countryInfo = indiainfo)
    }

    Surface(modifier = Modifier.fillMaxSize( ) ) {
Column(modifier = Modifier.fillMaxSize( )) {
LazyColumn {

}

    Countrycard(countryInfo = indiainfo)
    Countrycard(countryInfo = indiainfo)
    Countrycard(countryInfo = indiainfo)
    Countrycard(countryInfo = indiainfo)
}
    }
    }

}