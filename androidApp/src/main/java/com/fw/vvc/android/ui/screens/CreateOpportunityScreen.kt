package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.components.*
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun CreateOpportunityScreen(navHostController: NavHostController) {
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
            Spacer(modifier = Modifier.size(5.dp))
            Header(text = "Post an Opportunity")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "All fields are required unless marked as ‘optional’", style = MaterialTheme.typography.body1.copy(fontSize = 12.sp))
            Spacer(modifier = Modifier.size(20.dp))

            Separator()

            Spacer(modifier = Modifier.size(20.dp))
            Subtitle("About the opportunity")
            Spacer(modifier = Modifier.size(5.dp))

            FormTextField(label = "Opportunity Name")
            Spacer(modifier = Modifier.size(20.dp))
            FormMultilineTextField(label = "Description")
            Spacer(modifier = Modifier.size(20.dp))

            Subtitle("Details")

            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Location")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Number of people required")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Date")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Time")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Indoors or outdoors?")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Criminal Record Check required?")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Ideal Volunteer (Optional)")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Additional Information (Optional)")
            Spacer(modifier = Modifier.size(20.dp))

            Subtitle("Your Contact Information")

            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Name")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Email")
            Spacer(modifier = Modifier.size(20.dp))
            FormTextField(label = "Phone Number")
            Spacer(modifier = Modifier.size(20.dp))
            FillWidthButton(text = "POST") {

            }
        }
    }
}