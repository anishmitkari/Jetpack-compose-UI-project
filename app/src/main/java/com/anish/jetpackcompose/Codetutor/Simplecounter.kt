package com.anish.jetpackcompose.Codetutor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class Simplecounter : ComponentActivity() {
    private val viewmodel by viewModels<MainscreenViewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewmodel)
        }
    }
     @Composable
    fun MainScreen(viewmodel: MainscreenViewmodel) {
        viewmodel.counter?.observeAsState()?.value
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { viewmodel.Decrement?.invoke() }) {
                    Text(text = "Decrement")
                }
                Text(text = "${viewmodel.counter?.value}")

                Button(onClick = { viewmodel.Increment?.invoke() }) {
                    Text(text = "Increment")
                }
            }
        }
    }



}