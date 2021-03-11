package com.louis993546.compose95.calculator

import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.louis993546.compose95.components.AppBar95
import com.louis993546.compose95.components.Button95
import com.louis993546.compose95.components.Checkbox95
import com.louis993546.compose95.components.Cutout95
import com.louis993546.compose95.components.Window95
import javax.imageio.ImageIO
import com.louis993546.compose95.components.Window95Action as Action

fun main() {
    val title = "Compose95 Demo"
    Window(
        undecorated = true,
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
            modifier = Modifier.fillMaxHeight(),
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
            var isChecked by remember { mutableStateOf(false) }
            Column {
                Button95(onClick = { }) { Text("Hello, World") }
                Cutout95 {
                    Checkbox95(
                        modifier = Modifier.padding(16.dp),
                        isCheck = isChecked,
                        onClick = { isChecked = it }
                    )
                }
                Box(Modifier.background(Color.White).fillMaxWidth()) {
                    AppBar95()
                }
            }
        }
    }
}