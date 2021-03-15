package com.louis993546.compose95.calculator

import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.louis993546.compose95.components.Button95
import com.louis993546.compose95.components.Divider95
import com.louis993546.compose95.components.TextField95
import com.louis993546.compose95.components.Window95
import javax.imageio.ImageIO
import com.louis993546.compose95.components.Window95Action as Action

fun main() {
    val title = "Compose95 Demo"
    Window(
//        undecorated = true,
        undecorated = false,
        title = title,
        icon = ImageIO.read(Thread.currentThread().contextClassLoader.getResource("icon.png").openStream()),
    ) {
        val appWindow = LocalAppWindow.current

        val offsetX = remember { mutableStateOf(0f) }
        val offsetY = remember { mutableStateOf(0f) }

        val previousLocationX by remember { mutableStateOf(appWindow.x) }
        val previousLocationY by remember { mutableStateOf(appWindow.y) }
        val previousSizeX by remember { mutableStateOf(appWindow.width) }
        val previousSizeY by remember { mutableStateOf(appWindow.height) }

        // TODO why is this making the whole window jumping around?
//        appWindow.setLocation(offsetX.value.roundToInt(), offsetY.value.roundToInt())

        Window95(
            headerTitle = title,
            offsetX = offsetX,
            offsetY = offsetY,
            action = {
                when (it) {
                    Action.MinimizeClicked -> appWindow.minimize()
                    Action.MaximizeClicked ->
                        if (appWindow.isMaximized) {
                            appWindow.setSize(previousSizeX, previousSizeY)
                            appWindow.setLocation(previousLocationX, previousLocationY)
                        } else appWindow.maximize()
                    Action.CloseClicked -> appWindow.close()
                }
            }
        ) {
            Body95()
        }
    }
}

@Composable
fun Body95(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        // menu row
        Divider95()
        Calculator95()
    }
}

@Composable
fun Calculator95(
    modifier: Modifier = Modifier,
) {
    var value by remember { mutableStateOf("0") }
    val isScientific by remember { mutableStateOf(false) }

    fun processOnClick(clickedButton: String) {
        val digit = clickedButton.toIntOrNull()
        if (digit == null) {
            when (clickedButton) {
                "C" -> value = "0"
                else -> error("Unknown button $clickedButton")
            }
        } else {
            value += clickedButton
        }
    }

    Column(modifier = modifier.padding(8.dp)) {
        TextField95(
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            singleLine = true,
            value = value,
            onValueChange = { },
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            CalculatorButtonAlt95(text = "Back", onClick = { processOnClick("Back") })
            Spacer(modifier = Modifier.width(4.dp))
            CalculatorButtonAlt95(text = "CE", onClick = { processOnClick("CE") })
            Spacer(modifier = Modifier.width(4.dp))
            CalculatorButtonAlt95(text = "C", onClick = { processOnClick("C") })
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            ColumnOfButtons95(
                keys = listOf("MC", "MR", "MS", "M+"),
                onKeyClick = { println("$it clicked") },
            )
            Spacer(modifier = Modifier.width(10.dp))
            ColumnOfButtons95(
                keys = listOf("7", "4", "1", "0"),
                onKeyClick = { processOnClick(it) },
            )
            ColumnOfButtons95(
                keys = listOf("8", "5", "2", "+/-"),
                onKeyClick = { processOnClick(it) },
            )
            ColumnOfButtons95(
                keys = listOf("9", "6", "3", "."),
                onKeyClick = { processOnClick(it) },
            )
            ColumnOfButtons95(
                keys = listOf("/", "*", "-", "+"),
                onKeyClick = { println("$it clicked") },
            )
            ColumnOfButtons95(
                keys = listOf("sqrt", "%", "1/x", "="),
                onKeyClick = { println("$it clicked") },
            )
        }
    }
}

data class Key(
    val label: String,
    val color: Color, // TODO
)

@Composable
fun ColumnOfButtons95(
    modifier: Modifier = Modifier,
    keys: List<String>,
    onKeyClick: (String) -> Unit,
) {
    Column(modifier = modifier.padding(4.dp)) {
        keys.forEach { key ->
            CalculatorButton95(
                text = key,
                onClick = onKeyClick,
            )
            Spacer(modifier = Modifier.height(4.dp)) // TODO do not do this for the last row
        }
    }
}

@Composable
fun CalculatorButton95(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (String) -> Unit,
) {
    Button95(
        modifier = modifier.sizeIn(minWidth = 32.dp, minHeight = 28.dp),
        onClick = { onClick(text) },
    ) {
        BasicText(
            modifier = Modifier,
            text = text,
        )
    }
}

@Composable
fun CalculatorButtonAlt95(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (String) -> Unit,
) {
    Button95(
        modifier = modifier.sizeIn(minWidth = 44.dp, minHeight = 28.dp),
        onClick = { onClick(text) },
    ) {
        BasicText(
            modifier = Modifier,
            text = text,
        )
    }
}
