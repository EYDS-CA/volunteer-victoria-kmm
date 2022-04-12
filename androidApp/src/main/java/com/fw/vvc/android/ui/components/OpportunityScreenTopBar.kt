package com.fw.vvc.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun OpportunityScreenTopBar(title: String, navigationActions: NavigationActions) {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderText(
                text = title
            )
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Post",
                modifier = Modifier.clickable {
                    navigationActions.navigateToCreateOpportunity.invoke()
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        SearchTextField()
    }
}


@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h6.copy(fontSize = 16.sp),
    )
}