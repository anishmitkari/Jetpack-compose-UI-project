package com.anish.jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash))

    LaunchedEffect(true){
        delay(2000)

    /*    navController.navigate(NavGraph.Bottom.route){
            popUpTo(0)
            launchSingleTop=true
        }*/
    }


    Column {
        LottieAnimation(composition = composition, isPlaying = true, restartOnPlay = false, iterations = 4)
    }


}