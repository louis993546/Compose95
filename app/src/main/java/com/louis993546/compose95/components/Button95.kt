package com.louis993546.compose95.components

import androidx.compose.Composable
import androidx.ui.core.ContentDrawScope
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.graphics.StrokeCap
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.Row
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.louis993546.compose95.Color95

@Composable
fun Button95(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    body: @Composable() () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                indication = ButtonIndication95()
            ),
        backgroundColor = Color95.backgroundGrey,
        paddingStart = 8.dp,
        paddingEnd = 8.dp,
        paddingTop = 2.dp,
        paddingBottom = 2.dp,
        gravity = ContentGravity.Center
    ) {
        body()
    }
}

class ButtonIndication95 : Indication {
    private object Instance : IndicationInstance {
        override fun ContentDrawScope.drawIndication(interactionState: InteractionState) {
            drawContent()

            val (topLeft, bottomRight) = if (interactionState.contains(Interaction.Pressed)) {
                SolidColor(Color.Black) to SolidColor(Color.White)
            } else {
                SolidColor(Color.White) to SolidColor(Color.Black)
            }

            // draw top
            drawLine(
                topLeft,
                Offset(0f, 0f),
                Offset(size.width, 0f),
                Stroke(2.dp.toPx().value, cap = StrokeCap.square)
            )
            // draw left
            drawLine(
                topLeft,
                Offset(0f, 0f),
                Offset(0f, size.height),
                Stroke(2.dp.toPx().value, cap = StrokeCap.square)
            )

            // draw right
            drawLine(
                bottomRight,
                Offset(size.width, 0f),
                Offset(size.width, size.height),
                Stroke(2.dp.toPx().value, cap = StrokeCap.square)
            )
            // draw bottom
            drawLine(
                bottomRight,
                Offset(0f, size.height),
                Offset(size.width, size.height),
                Stroke(2.dp.toPx().value, cap = StrokeCap.square)
            )
        }

    }

    override fun createInstance(): IndicationInstance = Instance
}

@Composable
fun CloseButton95(onClick: () -> Unit) {

}

@Composable
fun ZoomButton95(onClick: () -> Unit) {

}

@Composable
fun MinimizeButton95(onClick: () -> Unit) {

}

/**
 * - [] x
 */
@Composable
fun MinZoomCloseButtons95(
    modifier: Modifier = Modifier,
    onMinimizeClicked: () -> Unit = {},
    onZoomClicked: () -> Unit = {},
    onCloseClicked: () -> Unit = {}
) {
    Row(modifier = modifier) {
        MinimizeButton95(onMinimizeClicked)
        ZoomButton95(onZoomClicked)
        CloseButton95(onCloseClicked)
    }
}

@Preview
@Composable
fun PreviewButton95() {
    Button95(onClick = {}) {
        Text(text = "default")
    }
}

@Preview
@Composable
fun PreviewMinZoomCloseButton95() {
    MinZoomCloseButtons95()
}