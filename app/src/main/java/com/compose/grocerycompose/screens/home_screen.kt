package com.compose.grocerycompose.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.compose.grocerycompose.R
import com.compose.grocerycompose.common.AppIconButton
import com.compose.grocerycompose.common.SpacerHeight
import com.compose.grocerycompose.common.SpacerWidth
import com.compose.grocerycompose.content.Fruit
import com.compose.grocerycompose.content.chipList
import com.compose.grocerycompose.content.fruitList
import com.compose.grocerycompose.navigation.DETAIL_SCREEN
import com.compose.grocerycompose.ui.theme.bgColor
import com.compose.grocerycompose.viewmodel.SharedViewModel


@Composable
fun HomeScreen(navHostController: NavHostController, sharedViewModel: SharedViewModel) {

    var currentMenuState by remember { mutableStateOf("Fruits") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        Column {
            AppHeader()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
                    .padding(10.dp)
            ) {
                chipList.forEach {
                    CustomChip(title = it, isSelected = it == currentMenuState, onClick = {
                        currentMenuState = it
                    })
                }
            }

            Box(
                modifier = Modifier
                    .background(bgColor)
                    .weight(3.5f)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2), modifier = Modifier.background(
                        bgColor
                    )
                )
                {
                    items(fruitList)
                    { fruit ->
                        showFruit(fruit)
                        {
                            Log.d("CHECK", "Called :" + it.title)
                            sharedViewModel.addFruit(it)
                            navHostController.navigate(DETAIL_SCREEN)
                        }

                    }
                }
            }

            SpacerHeight(10.dp)
            Box(modifier = Modifier.padding(10.dp)) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp))
                {
                    items(fruitList)
                    {
                        HorizontalCard(it)
                    }
                }
            }
        }

        BottomView(
            modifier = Modifier
                .padding(bottom = 20.dp, end = 10.dp)
                .align(BottomEnd)
        )
    }
}

@Composable
fun AppHeader() {
    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(10.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                AppIconButton(icon = R.drawable.drawer)
                SpacerWidth()
                Text(
                    text = "Nikit",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600
                    )
                )
            }
            AppIconButton(icon = R.drawable.search)
        }
    }
}

@Composable
fun showFruit(fruit: Fruit, onFruitClick: (Fruit) -> Unit) {
    Card(
        modifier = Modifier
            .background(Color.Gray)
            .padding(10.dp)
            .clickable { onFruitClick(fruit) }, shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White), contentAlignment = Center
        ) {
            Column(Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = fruit.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(70.dp)
                        .align(CenterHorizontally)
                )
                SpacerHeight()
                Text(
                    text = fruit.rs.toString() + " Rs",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300
                    ),
                    modifier = Modifier.align(CenterHorizontally),
                    maxLines = 1
                )
                SpacerHeight()
                Text(
                    text = fruit.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300
                    ),
                    modifier = Modifier.align(CenterHorizontally),
                    maxLines = 1
                )
                SpacerHeight()
                Text(
                    text = fruit.subTitle,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W200
                    ),
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .align(CenterHorizontally),
                    maxLines = 1
                )
                SpacerHeight()
                Button(
                    onClick = {},
                    modifier = Modifier.align(CenterHorizontally),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Red
                    )
                ) {
                    Text(
                        text = "Add",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CustomChip(title: String, isSelected: Boolean, onClick: (String) -> Unit) {
    TextButton(
        onClick = { onClick(title) },
        modifier = Modifier.padding(end = 10.dp),
        shape = RoundedCornerShape(200.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if (isSelected) Color.Red else Color.White)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (isSelected) Color.White else Color.Black
            )
        )
    }
}


@Composable
fun BottomView(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(Color.Gray)
    ) {
        Row {
            SpacerWidth(20.dp)
            Text(
                text = "Rs 300.00",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300
                ), modifier = Modifier.align(CenterVertically)
            )
            SpacerWidth(10.dp)
            Image(
                painter = painterResource(id = R.drawable.splash_logo),
                contentDescription = "",
                Modifier
                    .size(46.dp)
                    .padding(2.dp)
            )
        }
    }
}


@Composable
fun HorizontalCard(fruit: Fruit) {

    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(start = 10.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row() {
                Image(
                    painter = painterResource(id = fruit.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 10.dp, top = 10.dp)
                )
                Text(
                    text = fruit.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .align(CenterVertically)
                )
            }

            Text(
                text = fruit.subTitle,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300
                ),
                modifier = Modifier.padding(10.dp),
                maxLines = 1
            )
        }
    }

}

