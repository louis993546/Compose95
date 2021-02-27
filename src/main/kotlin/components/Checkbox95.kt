package components

import Color95
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            .border95(Elevation.Below)
            .clickable(onClick = { onClick(isCheck) })
            .background(Color95.checkboxWhite),
    ) {
        if (isCheck) Image(
            modifier = modifier.padding(2.dp),
            contentDescription = "",
            bitmap = imageResource("Check95.png")
        )
    }
}
