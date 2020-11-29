package components

import Color95
import androidx.compose.foundation.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp


@Composable
fun Checkbox95(
    modifier: Modifier = Modifier,
    isCheck: Boolean = false,
    onClick: (Boolean) -> Unit
) {
    // TODO need to lean how to do DrawModifier for the border
    Box(
        modifier = modifier
            .size(20.dp)
            .composed { DrawBorder95(Elevation.Below) }
            .clickable(onClick = { onClick(isCheck) }),
        backgroundColor = Color95.checkboxWhite
    ) {
        if (isCheck) Image(
            modifier = modifier.padding(2.dp),
            asset = imageResource("Check95.png")
        )
    }
}
