package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.components.FillWidthButton
import com.fw.vvc.android.ui.components.Header
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun ExpressInterestScreen(navHostController: NavHostController) {
    val navigationActions = remember(navHostController) {
        NavigationActions(navHostController)
    }

    Box(
       modifier = Modifier
           .fillMaxSize()
           .background(color = MaterialTheme.colors.background),
       contentAlignment = Alignment.Center
    ) {
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .background(color = MaterialTheme.colors.surface)
               .padding(vertical = 20.dp, horizontal = 20.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.Start
       ) {
           Header(text = "How to Apply")
           Spacer(modifier = Modifier.size(10.dp))
           Text(text = "To apply for this opportunity, please contact:", style = MaterialTheme.typography.body1)
           Spacer(modifier = Modifier.size(20.dp))
           Row {
               Text(text = "Organizer:", style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold))
               Text(text = "User", style = MaterialTheme.typography.body1)
           }
           Spacer(modifier = Modifier.size(10.dp))
           Row {
               Text(text = "Phone Number:", style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold))
               Text(text = "123-456-789", style = MaterialTheme.typography.body1)
           }
           Spacer(modifier = Modifier.size(10.dp))
           Row {
               Text(text = "Email:", style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold))
               Text(text = "Mary0222@gmail.com", style = MaterialTheme.typography.body1)
           }
           Spacer(modifier = Modifier.size(20.dp))
           Box (
               modifier = Modifier
                   .fillMaxWidth()
                   .background(
                       color = MaterialTheme.colors.secondary,
                       shape = RoundedCornerShape(10.dp)
                   )
                   .padding(20.dp)
           ) {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Icon(imageVector = Icons.Rounded.Warning, contentDescription = "Disclaimer")
                   Spacer(modifier = Modifier.size(20.dp))
                   Text(text = "Volunteer Victoria is not responsible for the post or what happens through it. Please make sure that the posting is legitimate and any liability concerns is discussed with the poster", style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.SemiBold))
               }
           }
           Spacer(modifier = Modifier.size(20.dp))
           FillWidthButton(text = "Ok", onClick = navigationActions.navigateToHome)
       }
    }
}