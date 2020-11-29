package components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TODO see if VT323 is good enough
 * TODO how to make it easy to switch between bitmap & vector font?
 */
@Composable
fun Text95(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(text, modifier)
}