package components

import Color95
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.ContentDrawScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

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
                2.dp.toPx()
            )
            // draw left
            drawLine(
                topLeft,
                Offset(0f, 0f),
                Offset(0f, size.height),
                2.dp.toPx()
            )

            // draw right
            drawLine(
                bottomRight,
                Offset(size.width, 0f),
                Offset(size.width, size.height),
                2.dp.toPx()
            )
            // draw bottom
            drawLine(
                brush = bottomRight,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = 2.dp.toPx(),
            )
        }

    }

    override fun createInstance(): IndicationInstance = Instance
}

// TODO what does it look like?
@Composable
fun CloseButton95(onClick: () -> Unit) {
    Button95(onClick = onClick) {
        androidx.compose.material.Text("X")
    }
}

@Composable
fun MaximizeButton95(onClick: () -> Unit) {
    Button95(onClick = onClick) {
        androidx.compose.material.Text("Max")
    }
}

@Composable
fun MinimizeButton95(onClick: () -> Unit) {
    Button95(onClick = onClick) {
        androidx.compose.material.Text("Min")
    }
}