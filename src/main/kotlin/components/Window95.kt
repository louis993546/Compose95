package components

import Color95
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.HorizontalGradient
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Window95(
    modifier: Modifier = Modifier,
    headerContent: @Composable() RowScope.() -> Unit,
    content: @Composable() () -> Unit
) {
    // TODO the border have 2 sets of colors (top + left & bottom + right)
    Column(
        modifier = modifier
            .background(Color95.backgroundGrey)
            .composed { DrawBorder95(elevation = Elevation.Above) }
    ) {
        val borderCompensationPadding = 4.dp
        WindowsHeader(modifier = Modifier.padding(4.dp)) {
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
    content: @Composable() RowScope.() -> Unit
) {
    WithConstraints(modifier = modifier) {
        Row(
            modifier = Modifier.background(
                HorizontalGradient(
                    colors = listOf(
                        Color(0, 0, 128),
                        Color(16, 52, 166)
                    ),
                    startX = 0f,
                    endX = constraints.maxWidth.toFloat(),
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
    action: (Window95Action) -> Unit,
    content: @Composable() () -> Unit
) {
    Window95(
        modifier = modifier,
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