package components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun Anchor95(modifier: Modifier = Modifier, text: String, action: () -> Unit) {
    Text(
        modifier = modifier.clickable(onClick = action),
        textDecoration = TextDecoration.Underline,
        style = TextStyle.Default.copy(color = Color95.anchorBlue),
        text = text
    )
}

// TODO anchor with text: how to design an API that is easy to use
