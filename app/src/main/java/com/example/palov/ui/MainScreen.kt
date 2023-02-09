package com.example.palov.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.palov.ui.component.BottomBar
import com.example.palov.ui.screen.MainNavGraph

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navHostController)
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            MainNavGraph(navHostController = navHostController)
        }
    }
}