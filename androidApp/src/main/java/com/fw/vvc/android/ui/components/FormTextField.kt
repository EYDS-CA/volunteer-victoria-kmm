package com.fw.vvc.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormTextField(label: String, modifier: Modifier = Modifier.fillMaxWidth(),) {
    OutlinedTextField(
        modifier = modifier,
        singleLine = true,
        maxLines = 1,
        label = { Text(text = label) },
        value = "",
        onValueChange = {}
    )
}
@Composable
fun FormMultilineTextField(label: String) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().height(350.dp),
        singleLine = false,
        maxLines = Int.MAX_VALUE,
        label = { Text(text = label) },
        value = "",
        onValueChange = {}
    )
}