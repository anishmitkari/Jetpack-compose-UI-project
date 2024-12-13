package com.anish.jetpackcompose.Furniture.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anish.jetpackcompose.Furniture.Screen.CheckoutScreen
import com.anish.jetpackcompose.Furniture.Screen.HomeScreen
import com.anish.jetpackcompose.Furniture.Screen.ProductDetailScreen

@Composable
fun FurnitureNavigation() {

    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Home) {
        composable(Home) { HomeScreen(navHostController) }
        composable(ProductDetail) { ProductDetailScreen(navHostController) }
        composable(Checkout) { CheckoutScreen(navHostController) }

    }

}

const val Home = "home_screen"
const val ProductDetail = "product_detail_screen"
const val Checkout = "check_out_screen"