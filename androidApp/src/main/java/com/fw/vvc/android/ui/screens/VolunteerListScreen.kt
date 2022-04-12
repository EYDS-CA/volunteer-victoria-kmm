package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.components.*
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun VolunteerListScreen(navHostController: NavHostController) {
    val navigationActions = remember(navHostController) {
        NavigationActions(navHostController)
    }

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(vertical = 20.dp, horizontal = 15.dp),
        topBar = { BackButton(navigationActions) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
                .verticalScroll(scrollState)
        ) {
            Text(text = "Opportunity Title", style = MaterialTheme.typography.body1.copy(fontSize = 14.sp), fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.size(10.dp))
            Header(text = "Volunteers List")
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Below are all the people who expressed interest in your opportunity. Select the people who showed up to your event and click save", style = MaterialTheme.typography.body1.copy(fontSize = 14.sp))
            Spacer(modifier = Modifier.size(20.dp))
            (0..5).map {
                VolunteerItem(name = "John Doe")
            }
            Spacer(modifier = Modifier.size(20.dp))
            FillWidthButton(text = "Save") {}
        }
    }
}

@Composable
fun VolunteerItem(name: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Separator()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = false, onCheckedChange = {})
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = name, style = MaterialTheme.typography.body1.copy(fontSize = 14.sp))
        }
        FormTextField(label = "Notes")
        Spacer(modifier = Modifier.size(10.dp))
    }
}