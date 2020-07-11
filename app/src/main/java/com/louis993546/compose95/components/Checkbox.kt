package com.louis993546.compose95.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Image
import androidx.ui.foundation.clickable
import androidx.ui.layout.padding
import androidx.ui.layout.size
import androidx.ui.material.Button
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.louis993546.compose95.Color95
import com.louis993546.compose95.ColorHex95
import com.louis993546.compose95.R

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
        if (isCheck) Image(
            modifier = modifier.padding(2.dp),
            asset = vectorResource(id = R.drawable.ic_check95)
        )
    }
}

@Composable
fun Checkbox95(
    modifier: Modifier = Modifier,
    onCheckChanged: (Boolean) -> Unit
) {
    val (isChecked, setCheck) = state { false }
    Checkbox95(modifier = modifier, isCheck = isChecked) {
        setCheck(!it)
        onCheckChanged(!it)
    }
}

@Preview(backgroundColor = ColorHex95.backgroundGrey)
@Composable
fun PreviewCheckBox95Off() {
    Checkbox95(isCheck = false) { }
}

@Preview
@Composable
fun PreviewCheckBox95On() {
    Checkbox95(isCheck = true) { }
}