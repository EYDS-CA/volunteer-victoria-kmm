package com.fw.vvc.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun FillWidthButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick.invoke() },
        modifier = Modifier.fillMaxWidth(),
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.body1.copy(fontSize = 14.sp)
            )
        }
    )
}