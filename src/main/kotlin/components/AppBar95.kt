package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

/**
 * TODO how to do the hover menu thing?
 */
@Composable
fun AppBar95(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color95.backgroundGrey)
            .composed { DrawBorder95(elevation = Elevation.Above) }
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Button95(onClick = { }) {
                Text95("Start")
            }
        }
    }
}