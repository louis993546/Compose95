package com.louis993546.compose95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextField95(
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        modifier = modifier
            .border95(Elevation.Below)
            .background(color = Color.White)
            .padding(8.dp),
        readOnly = readOnly,
        singleLine = singleLine,
        value = value,
        onValueChange = onValueChange,
    )
}