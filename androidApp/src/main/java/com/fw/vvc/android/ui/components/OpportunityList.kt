package com.fw.vvc.android.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun OpportunityList(navigationActions: NavigationActions, isUserList: Boolean) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 10.dp).padding(bottom = 25.dp),
    ) {
        items(5) {
            OpportunityItem(navigationActions, isUserList)
        }
    }
}