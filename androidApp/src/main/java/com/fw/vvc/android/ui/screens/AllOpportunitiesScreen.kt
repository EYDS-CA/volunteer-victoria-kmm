package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.components.OpportunityList
import com.fw.vvc.android.ui.components.OpportunityScreenTopBar
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun AllOpportunitiesScreen(navHostController: NavHostController) {
    val navigationActions = remember(navHostController) {
        NavigationActions(navHostController)
    }

    Scaffold (
        modifier = Modifier.fillMaxSize().padding(
            horizontal = 5.dp,
            vertical = 20.dp
        ),
        topBar = { OpportunityScreenTopBar("All Opportunities", navigationActions) },
        content = { OpportunityList(navigationActions, false) }
    )
}