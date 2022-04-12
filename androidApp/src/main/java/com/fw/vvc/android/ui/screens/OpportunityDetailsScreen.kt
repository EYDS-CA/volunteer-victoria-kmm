package com.fw.vvc.android.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fw.vvc.android.ui.components.*
import com.fw.vvc.android.ui.navigation.NavigationActions
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun OpportunityDetailsScreen(navHostController: NavHostController) {
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
            Header(text = "Opportunity title")
            Spacer(modifier = Modifier.size(10.dp))
            Poster(text = "For User")
            Spacer(modifier = Modifier.size(10.dp))
            Separator()
            Spacer(modifier = Modifier.size(10.dp))
            Subtitle("Description")
            Spacer(modifier = Modifier.size(10.dp))
            Description()
            Spacer(modifier = Modifier.size(10.dp))
            Separator()
            Spacer(modifier = Modifier.size(10.dp))
            Subtitle(text = "Details")
            Spacer(modifier = Modifier.size(10.dp))
            Details()
            Spacer(modifier = Modifier.size(10.dp))
            FillWidthButton(text = "Express Interest", onClick = navigationActions.navigateToExpressInterest)
        }
    }
}

@Composable
fun Poster(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1.copy(fontSize = 14.sp, fontWeight = FontWeight.Medium)
    )
}

@Composable
fun Description() {
    Text(
        text = "Our volunteer Computer Technicians will gain hands-on experience with computer refurbishment. All you need are a pair of steel toed boots, to be over the age of 16, and a great attitude!\n" +
                "\n" +
                "Duties may include\n" +
                "\n" +
                "Providing support to the lead instructor. Support may include but is not limited to:\n" +
                "Participate in activities including off-site excursions\n" +
                "Facilitating social opportunities\n" +
                "Implementing activities to achieve goals\n" +
                "Mentoring healthy relationships\n" +
                "Self-advocacy and communication\n" +
                "Implementing activities to achieve goals\n" +
                "Mentoring healthy relationships\n" +
                "Self-advocacy and communication\n" +
                "Implementing activities to achieve goals\n" +
                "Mentoring healthy relationships\n" +
                "Self-advocacy and communication\n" +
                "Implementing activities to achieve goals\n" +
                "Mentoring healthy relationships\n" +
                "Self-advocacy and communication\n" +
                "Implementing activities to achieve goals\n" +
                "Mentoring healthy relationships\n" +
                "Self-advocacy and communication\n" +
                "Making crafts, karaoke, playing Wii - just having fun.",
        style = MaterialTheme.typography.body1.copy(fontSize = 13.sp)
    )
}

@Composable
fun Details() {
    FlowRow {
        repeat(12) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
            ) {
                Detail(pair = "Title: " to "Detail content")
            }
        }
    }
}

@Composable
fun Detail(pair: Pair<String, String>) {
    Column {
        Text(
            text = pair.first,
            style = MaterialTheme.typography.body1.copy(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = pair.second,
            style = MaterialTheme.typography.body1.copy(fontSize = 12.sp)
        )
        Spacer(modifier = Modifier.size(10.dp))
    }
}