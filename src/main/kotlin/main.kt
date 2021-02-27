import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import components.AppBar95
import components.Button95
import components.Checkbox95
import components.Cutout95
import components.Window95
import components.Window95Action
import javax.imageio.ImageIO
import kotlin.math.roundToInt

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
                    Window95Action.MinimizeClicked -> appWindow.minimize()
                    Window95Action.MaximizeClicked ->
                        if (appWindow.isMaximized) {
                            appWindow.setSize(previousSizeX, previousSizeY)
                            appWindow.setLocation(previousLocationX, previousLocationY)
                        } else appWindow.maximize()
                    Window95Action.CloseClicked -> appWindow.close()
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