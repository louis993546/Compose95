package components

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.unit.dp

@Composable
fun Button95(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    body: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .padding(
                horizontal = 8.dp,
                vertical = 2.dp,
            )
            .background(Color95.backgroundGrey)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = ButtonIndication95
            ),
//        gravity = ContentGravity.Center
    ) {
        body()
    }
}

object ButtonIndication95 : Indication {
    private class ButtonIndication95Instance(
        private val isPressed: State<Boolean>
        ) : IndicationInstance {
        override fun ContentDrawScope.drawIndication() {
            drawContent()
            val (topLeft, bottomRight) = if (isPressed.value) {
                SolidColor(Color.Black) to SolidColor(Color.White)
            } else {
                SolidColor(Color.White) to SolidColor(Color.Black)
            }

            // draw top
            drawLine(
                brush = topLeft,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 2.dp.toPx()
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

    @Composable
    override fun rememberUpdatedInstance(
        interactionSource: InteractionSource,
    ): IndicationInstance {
        val isPressed = interactionSource.collectIsPressedAsState()
        return remember(interactionSource) { ButtonIndication95Instance(isPressed) }
    }
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