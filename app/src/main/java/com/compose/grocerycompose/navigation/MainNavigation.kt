package com.compose.grocerycompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.grocerycompose.screens.DetailsScreen
import com.compose.grocerycompose.screens.HomeScreen
import com.compose.grocerycompose.screens.StartScreen
import com.compose.grocerycompose.viewmodel.SharedViewModel

@Composable
fun MainNavigation() {

    val sharedViewModel: SharedViewModel = viewModel()
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = SPLASH_SCREEN)
    {
        composable(SPLASH_SCREEN)
        {
            StartScreen(navHostController = navHostController)
        }

        composable(HOME_SCREEN)
        {
            HomeScreen(navHostController = navHostController, sharedViewModel = sharedViewModel)
        }

        composable(DETAIL_SCREEN)
        {
            DetailsScreen(navHostController = navHostController, sharedViewModel = sharedViewModel)
        }
    }
}

const val SPLASH_SCREEN = "splash_screen"
const val HOME_SCREEN = "home_screen"
const val DETAIL_SCREEN = "detail_screen"
