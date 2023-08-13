package com.compose.grocerycompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.compose.grocerycompose.content.Fruit

class SharedViewModel : ViewModel()
{

    var fruit by mutableStateOf<Fruit?>(null)
        private set

    fun addFruit(newFruit : Fruit)
    {
        fruit = newFruit
    }



}