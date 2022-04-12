package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {
    val pagerState = rememberPagerState(
        initialPage = 0
    )

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.background(color = Color.Gray),
        bottomBar = {
            HomeBottomBar(pagerState = pagerState, coroutineScope = coroutineScope)
        },
        content = {
            ViewPager(pagerState = pagerState, navHostController = navHostController)
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeBottomBar(pagerState: PagerState, coroutineScope: CoroutineScope) {
    val tabData = listOf(
        Icons.Filled.Home,
        Icons.Filled.Person,
    )

    val tabIndex = pagerState.currentPage

    Surface(
        elevation = 20.dp
    ) {
        TabRow(
            backgroundColor = MaterialTheme.colors.surface,
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = MaterialTheme.colors.primary,
                    height = 3.dp
                )
            }
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(
                    modifier = Modifier.height(50.dp),
                    selected = tabIndex == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    icon = { Icon(imageVector = pair, contentDescription = "Bottom bar option", tint = MaterialTheme.colors.primary) }
                )
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPager(pagerState: PagerState, navHostController: NavHostController) {
    HorizontalPager(
        state = pagerState,
        count = 2
    ) { index ->
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background),
            content = {
                when(index) {
                    0 -> AllOpportunitiesScreen(navHostController)
                    1 -> MyOpportunitiesScreen(navHostController)
                }
            }
        )

    }
}