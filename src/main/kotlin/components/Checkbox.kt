package components

import Color95
import ColorHex95
import androidx.compose.foundation.Box
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
            .clickable(onClick = { onClick(isCheck) }),
        backgroundColor = Color95.checkboxWhite
    ) {
//        if (isCheck) Image(
//            modifier = modifier.padding(2.dp),
//            asset = vectorResource(id = R.drawable.ic_check95)
//        )
    }
}

@Composable
fun Checkbox95(
    modifier: Modifier = Modifier,
    onCheckChanged: (Boolean) -> Unit
) {
    var isChecked by remember { mutableStateOf(false) }
    Checkbox95(modifier = modifier, isCheck = isChecked) {
        isChecked = !isChecked
        onCheckChanged(!it)
    }
}