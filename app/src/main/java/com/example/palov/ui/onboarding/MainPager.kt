package com.example.palov.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.palov.R
import com.example.palov.ui.component.AppText
import com.example.palov.ui.component.LottiAnim
import com.example.palov.ui.splash.SplashViewModel
import com.example.palov.ui.theme.ItemFont
import com.example.palov.util.Graph
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainPager(
    navHostController: NavHostController
) {
    val viewModel: SplashViewModel = hiltViewModel()
    val pagerState = rememberPagerState(0)
    val anim = listOf(
        R.raw.pager1,
        R.raw.pager2,
        R.raw.pager3
    )
    val map = mapOf(
        "Browse" to "Display recipes to inspire visitors when they browse your own packaged foods (whether dips, sauces, pickles, wraps, you name it!)",
        "Order" to "Easy order, fast delivery and comfort payment.",
        "Enjoy" to "Enjoy your foods, enjoy your life. Life is combination magic and pasta )"
    ).toList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(5.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(2.5f)
        ) { index ->
            Pager(title = map[index].first, desc = map[index].second, anim = anim[index])
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Center
        ) {
            if (pagerState.currentPage != 2) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = MaterialTheme.colorScheme.onSecondary
                )
            } else {
                ElevatedButton(
                    onClick = {
                        viewModel.saveUserVisiting(true)
                        navHostController.navigate(Graph.MAIN) {
                            popUpTo("ON_BOARDING") {
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier.size(height = 55.dp, width = 280.dp),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.onSecondary)
                ) {
                    AppText(
                        text = "Get Started",
                        size = 20,
                        color = Color.White,
                        fontFamily = ItemFont
                    )
                }
            }
        }
    }
}

@Composable
fun Pager(
    title: String,
    desc: String,
    anim: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottiAnim(anim = anim, modifier = Modifier.height(300.dp))
        Spacer(modifier = Modifier.height(20.dp))
        AppText(
            text = title,
            size = 32,
            color = MaterialTheme.colorScheme.onSecondary,
            fontFamily = ItemFont
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            text = desc,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondary,
            fontFamily = ItemFont,
            textAlign = TextAlign.Center
        )
    }
}