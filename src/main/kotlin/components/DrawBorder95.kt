package components

import Color95
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp

/**
 * TODO is drawPath better than drawLine multiple times?
 */
fun Modifier.border95(elevation: Elevation): Modifier = composed(
    factory = {
        this.then(
            Modifier.drawWithCache {
                onDrawWithContent {
                    drawContent()

                    val topLeft = if (elevation.isAbove()) Color.White else Color.Black
                    val bottomRight = if (elevation.isAbove()) Color.Black else Color.White
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
        )
    },
    inspectorInfo = debugInspectorInfo {
        name = "border95"
        properties["elevation"] = elevation
    }
)

enum class Elevation {
    Above,
    Below,
}

fun Elevation.isAbove() = this == Elevation.Above
fun Elevation.isBelow() = this == Elevation.Below