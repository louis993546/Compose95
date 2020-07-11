package com.louis993546.compose95.components

import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.HorizontalGradient
import androidx.ui.graphics.StrokeCap
import androidx.ui.graphics.TileMode
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.louis993546.compose95.Color95

@Composable
fun Window95(
    modifier: Modifier = Modifier,
    headerContent: @Composable() RowScope.() -> Unit,
    content: @Composable() () -> Unit
) {
    // TODO the border have 2 sets of colors (top + left & bottom + right)
    Column(
        modifier = modifier
            .drawBackground(Color95.backgroundGrey)
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

        val thickness = (2.dp * density).toPx().value
        val thickness1 = (4.dp * density).toPx().value

        // draw top
        drawLine(
            Color95.backgroundGrey,
            Offset(0f, 0f),
            Offset(size.width, 0f),
            Stroke(thickness1, cap = StrokeCap.square)
        )
        drawLine(
            Color95.backgroundGrey,
            Offset(0f, 0f),
            Offset(0f, size.height),
            Stroke(thickness1, cap = StrokeCap.square)
        )
        drawLine(
            topLeft,
            Offset(0f, 0f),
            Offset(size.width, 0f),
            Stroke(thickness, cap = StrokeCap.square)
        )
        drawLine(
            topLeft,
            Offset(0f, 0f),
            Offset(0f, size.height),
            Stroke(thickness, cap = StrokeCap.square)
        )

        drawLine(
            grey2,
            Offset(size.width, thickness1),
            Offset(size.width, size.height),
            Stroke(thickness1, cap = StrokeCap.square)
        )
        drawLine(
            grey2,
            Offset(thickness1, size.height),
            Offset(size.width, size.height),
            Stroke(thickness1, cap = StrokeCap.square)
        )
        drawLine(
            bottomRight,
            Offset(size.width, thickness),
            Offset(size.width, size.height),
            Stroke(thickness, cap = StrokeCap.square)
        )
        drawLine(
            bottomRight,
            Offset(thickness, size.height),
            Offset(size.width, size.height),
            Stroke(thickness, cap = StrokeCap.square)
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
            modifier = Modifier.drawBackground(
                HorizontalGradient(
                    colors = listOf(
                        Color(0, 0, 128),
                        Color(16, 52, 166)
                    ),
                    startX = 0f,
                    endX = this.constraints.maxWidth.value.toFloat(),
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

@Preview
@Composable
fun PreviewWindow95() {
    Window95(
        headerContent = {
            Text(
                modifier = Modifier.weight(1f).padding(4.dp),
                text = "compose95.exe",
                color = Color.White,
                style = TextStyle.Default.copy(fontWeight = FontWeight.W700)
            )
            Button95(
                modifier = Modifier
                    .gravity(Alignment.CenterVertically)
                    .preferredSize(25.dp),
                onClick = {}
            ) {
                Text(text = "x", style = TextStyle.Default.copy(fontWeight = FontWeight.Bold))
            }
        }
    ) {
        Text("This is a Window")
    }
}