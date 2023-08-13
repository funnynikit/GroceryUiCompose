package com.compose.grocerycompose.screens

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.compose.grocerycompose.common.SpacerHeight
import com.compose.grocerycompose.viewmodel.SharedViewModel

@Composable
fun DetailsScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {

    val fruit = sharedViewModel.fruit
    LaunchedEffect(key1 = fruit)
    {
        if (fruit != null) {
            Log.d("DETAIL", fruit.title)
            Log.d("DETAIL", fruit.subTitle)
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (fruit != null) {
                ShowImage(image = fruit.image, modifier = Modifier)
            }
            SpacerHeight()
            Text(
                text = fruit?.subTitle ?: "sorry, no content found!",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                style = TextStyle(color = Color.Black, fontSize = 14.sp, FontWeight.W500)
            )
        }
    }
}

@Composable
fun ShowImage(@DrawableRes image: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = image), contentDescription = "",
        modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(20.dp)
    )
}