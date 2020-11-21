import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import components.Button95
import components.Checkbox95
import components.Window95
import components.Window95Action
import javax.imageio.ImageIO

fun main() {
    val title = "Compose95 Demo"
    Window(
        undecorated = true,
        title = title,
        icon = ImageIO.read(Thread.currentThread().contextClassLoader.getResource("icon.png").openStream())
    ) {
        val appWindow = AppWindowAmbient.current

        Window95(
            modifier = Modifier.fillMaxHeight(),
            headerTitle = title,
            action = {
                when (it) {
                    Window95Action.MinimizeClicked -> TODO("It is OS dependent, right?")
                    Window95Action.MaximizeClicked -> TODO("how to get screen size?")
                    Window95Action.CloseClicked -> appWindow?.close()
                }
            }
        ) {
            Column {
                Button95(onClick = { }) { Text("Hello, World") }
                Checkbox95 { }
            }
        }
    }
}