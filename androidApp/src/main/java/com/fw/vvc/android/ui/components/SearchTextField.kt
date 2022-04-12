package com.fw.vvc.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTextField() {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
                spotColor = Color.Gray.copy(alpha = 0.4f),
                ambientColor = Color.Gray.copy(alpha = 0.4f)
            )
    ) {
        TextField(
            value = "",
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.body1.copy(fontSize = 14.sp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = { Image(imageVector = Icons.Default.Search, contentDescription = "Search") },
            placeholder = { SearchTextFieldPlaceholder() },
            singleLine = true,
            maxLines = 1,
            onValueChange = {

            }
        )
    }
}

@Composable
fun SearchTextFieldPlaceholder() {
    Text(text = "Search Keyword", style = MaterialTheme.typography.body1.copy(fontSize = 14.sp))
}