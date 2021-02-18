package components

import Color95
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.Interaction
import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ContentDrawScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun Button95(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    body: @Composable() BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .background(Color95.backgroundGrey)
            .clickable(
                onClick = onClick,
                indication = ButtonIndication95()
            )
            .padding(horizontal = 8.dp, vertical = 2.dp),
        alignment = Alignment.Center
    ) {
        body()
    }
}

/**
 * This is for the min/max/close button. They have specific size and padding to make sure it looks right
 */
@Composable
fun WindowButton95(
    modifier: Modifier = Modifier,
    icon: ImageAsset,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(Color95.backgroundGrey)
            .clickable(
                onClick = onClick,
                indication = ButtonIndication95()
            )
            .size(14.dp),
        alignment = Alignment.Center
    ) { Image(icon) }
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
fun CloseButton95(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button95(modifier = modifier, onClick = onClick) {
//        Text95("X", modifier = Modifier.size(12.dp))
        Box(modifier = Modifier.size(12.dp))
    }
}

@Composable
fun MaximizeButton95(onClick: () -> Unit) {
    Button95(onClick = onClick) {
        Text95("Max")
    }
}

@Composable
fun MinimizeButton95(onClick: () -> Unit) {
    Button95(onClick = onClick) {
        Text95("Min")
    }
}