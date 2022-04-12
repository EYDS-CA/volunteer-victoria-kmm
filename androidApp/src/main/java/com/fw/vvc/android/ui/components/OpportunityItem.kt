package com.fw.vvc.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fw.vvc.android.R
import com.fw.vvc.android.ui.navigation.NavigationActions

@Composable
fun OpportunityItem(navigationActions: NavigationActions, isUserPost: Boolean) {
    val openDialog = remember { mutableStateOf(false)  }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = Color.Gray.copy(alpha = 0.4f),
                    ambientColor = Color.Gray.copy(alpha = 0.4f)
                ),
            backgroundColor = MaterialTheme.colors.surface,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Header(text = "Opportunity title")
                Spacer(modifier = Modifier.height(5.dp))
                OpportunityPoster(text = "For User")
                Spacer(modifier = Modifier.height(10.dp))
                OpportunityDetails()
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(), 
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DetailButton(navigationActions)

                    if (isUserPost) {
                        PostCreatorOptions(navigationActions, openDialog)
                    }
                }
            }
        }
    }

    if (openDialog.value) {
        DeleteDialog(openDialog)
    }
}

@Composable
fun OpportunityPoster(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1.copy(fontSize = 12.sp)
    )
}

@Composable
fun OpportunityDetails() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        OpportunityDetail(text = "June 14, 2022", imageVector = Icons.Filled.DateRange)
        OpportunityDetail(text = "12-7pm", imageVector = Icons.Filled.Check)
        OpportunityDetail(text = "Recr. 2", imageVector = Icons.Filled.Person)
    }
}

@Composable
fun OpportunityDetail(text: String, imageVector: ImageVector) {
    Row( horizontalArrangement = Arrangement.Center ){
        Image(imageVector = imageVector, contentDescription = "Detail", modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text, style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun DetailButton(navigationActions: NavigationActions) {
    Button(
        onClick = navigationActions.navigateToDetail,
        content = {
            Text(
                text = "View Details",
                style = MaterialTheme.typography.body1.copy(fontSize = 14.sp)
            )
        }
    )
}

@Composable
fun DeleteDialog(openDialog: MutableState<Boolean>) {
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Text(text = "Warning!")
        },
        text = {
            Text("Are you sure that you want to delete this post?")
        },
        confirmButton = {
            Button(
                onClick = {
                    openDialog.value = false
                }) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    openDialog.value = false
                }) {
                Text("No")
            }
        }
    )
}

@Composable
fun PostCreatorOptions(navigationActions: NavigationActions, openDialog: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Edit",
            tint = MaterialTheme.colors.primaryVariant,
            modifier = Modifier.clickable {
                navigationActions.navigateToVolunteersList.invoke()
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Edit",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.clickable {
                navigationActions.navigateToCreateOpportunity.invoke()
            }
        )
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            tint = MaterialTheme.colors.error,
            modifier = Modifier.clickable {
                openDialog.value = true
            }
        )
    }
}