package com.example.modernuidashboards.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.modernuidashboards.Banner
import com.example.modernuidashboards.Categories
import com.example.modernuidashboards.ItemList
import com.example.modernuidashboards.MyBottomBar
import com.example.modernuidashboards.PopularCourses
import com.example.modernuidashboards.SearchRow

@Preview(showBackground = true)
@Composable
fun MyUI() {
    Scaffold(
        bottomBar = { MyBottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchRow()
            Banner()
            Categories()
            PopularCourses()
            ItemList()
        }
    }
}