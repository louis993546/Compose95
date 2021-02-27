package components

import Color95
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * It's basically the same thing: grey background + a border but flipped
 */
@Composable
fun Cutout95(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier.background(Color95.backgroundGrey)
            .border95(Elevation.Below)
    ) {
        content()
    }
}