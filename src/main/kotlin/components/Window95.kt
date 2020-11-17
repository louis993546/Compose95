package components


import Color95
import androidx.compose.foundation.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ContentDrawScope
import androidx.compose.ui.DrawModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
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
            .composed { DrawBorder95() }
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

// TODO learn drawPath
class DrawBorder95 : DrawModifier {
    override fun ContentDrawScope.draw() {
        drawContent()

        val topLeft = Color.White
        val bottomRight = Color.Black
        val grey2 = Color(0xFF888C8F)

        val thickness = (2.dp * density).toPx()
        val thickness1 = (4.dp * density).toPx()

        // draw top
        drawLine(
            Color95.backgroundGrey,
            Offset(0f, 0f),
            Offset(size.width, 0f),
            thickness1
        )
        drawLine(
            Color95.backgroundGrey,
            Offset(0f, 0f),
            Offset(0f, size.height),
            thickness1
        )
        drawLine(
            topLeft,
            Offset(0f, 0f),
            Offset(size.width, 0f),
            thickness
        )
        drawLine(
            topLeft,
            Offset(0f, 0f),
            Offset(0f, size.height),
            thickness
        )

        drawLine(
            grey2,
            Offset(size.width, thickness1),
            Offset(size.width, size.height),
            thickness1
        )
        drawLine(
            grey2,
            Offset(thickness1, size.height),
            Offset(size.width, size.height),
            thickness1
        )
        drawLine(
            bottomRight,
            Offset(size.width, thickness),
            Offset(size.width, size.height),
            thickness
        )
        drawLine(
            bottomRight,
            Offset(thickness, size.height),
            Offset(size.width, size.height),
            thickness
        )

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
                    endX = this.constraints.maxWidth.toFloat(),
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
        },
        content = content
    )
}