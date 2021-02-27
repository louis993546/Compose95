package components

import Color95
import androidx.compose.desktop.LocalAppWindow
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Window95(
    modifier: Modifier = Modifier,
    offsetX: MutableState<Float>,
    offsetY: MutableState<Float>,
    headerContent: @Composable RowScope.() -> Unit,
    content: @Composable () -> Unit
) {
    // TODO the border have 2 sets of colors (top + left & bottom + right)
    Column(
        modifier = modifier
            .background(Color95.backgroundGrey)
            .border95(Elevation.Above)
    ) {
        val borderCompensationPadding = 4.dp
        val appWindow = LocalAppWindow.current
        WindowsHeader(
            modifier = Modifier.padding(4.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX.value += dragAmount.x
                        offsetY.value += dragAmount.y

                    }
                },
        ) {
            headerContent()
        }
        Box(modifier = Modifier.padding(borderCompensationPadding)) {
            content()
        }
    }
}

@Composable
fun WindowsHeader(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        Row(
            modifier = Modifier.background(
                Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0, 0, 128),
                        1f to Color(16, 52, 166),
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(constraints.maxWidth.toFloat(), 0f),
                    tileMode = TileMode.Repeated
                )
            )
        ) {
            this.content()
        }
    }
}

/**
 * Short version of Window95 where there is only title, and nothing else
 */
@Composable
fun Window95(
    modifier: Modifier = Modifier,
    headerTitle: String,
    offsetX: MutableState<Float>,
    offsetY: MutableState<Float>,
    action: (Window95Action) -> Unit,
    content: @Composable() () -> Unit
) {
    Window95(
        modifier = modifier,
        offsetX = offsetX,
        offsetY = offsetY,
        headerContent = {
            Text(
                modifier = Modifier.weight(1f).padding(4.dp),
                text = headerTitle,
                color = Color.White,
                style = TextStyle.Default.copy(fontWeight = FontWeight.W700)
            )
            MinimizeButton95 { action(Window95Action.MinimizeClicked) }
            MaximizeButton95 { action(Window95Action.MaximizeClicked) }
            CloseButton95 { action(Window95Action.CloseClicked) }
        },
        content = content
    )
}

enum class Window95Action {
    MinimizeClicked,
    MaximizeClicked,
    CloseClicked,
}