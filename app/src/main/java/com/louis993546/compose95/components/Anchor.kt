package com.louis993546.compose95.components

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextDecoration
import androidx.ui.tooling.preview.Preview

@Composable
fun Anchor(modifier: Modifier = Modifier, text: String, action: () -> Unit) {
    Text(
        modifier = modifier.clickable(onClick = action),
        textDecoration = TextDecoration.Underline,
        style = TextStyle.Default.copy(
            color = Color(16, 52, 166)
        ),
        text = text
    )
}

// TODO anchor with text: how to design an API that is easy to use

@Preview
@Composable
fun PreviewAnchor() {
    Anchor(text = "Expensive Toys") { /* action */ }
}