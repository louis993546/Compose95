package com.louis993546.compose95.components

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.WithConstraints
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.drawBorder
import androidx.ui.graphics.Color
import androidx.ui.graphics.HorizontalGradient
import androidx.ui.graphics.TileMode
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun Window95(
    modifier: Modifier = Modifier,
    headerContent: @Composable() RowScope.() -> Unit,
    content: @Composable() () -> Unit
) {
    // TODO the border have 2 sets of colors (top + left & bottom + right)
    Column(
        modifier = modifier
            .drawBackground(Color(206, 208, 207))
            .drawBorder(2.dp, Color.White)
            .padding(2.dp)
    ) {
        WindowsHeader {
            headerContent()
        }
        content()
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