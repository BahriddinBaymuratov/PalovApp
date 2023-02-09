package com.example.palov.ui.component

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.palov.ui.theme.AppFont
import com.example.palov.util.SearchWidgetState

@Composable
fun MainTopBar(
    searchWidgetState: SearchWidgetState,
    onActionClicked: () -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            TopAppBar(
                title = {
                    Text(
                        text = "Recipes",
                        fontFamily = AppFont,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                },
                backgroundColor = MaterialTheme.colorScheme.primary,
                actions = {
                    IconButton(onClick = {
                        onActionClicked()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }
        SearchWidgetState.OPENED -> {
            SearchAppBar(
                onCloseClicked = {
                    onCloseClicked()
                },
                onSearchClicked = {
                   onSearchClicked(it)
                }
            )
        }
    }
}