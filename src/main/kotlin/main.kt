import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import components.Button95
import components.Checkbox95
import components.Window95
import javax.imageio.ImageIO

fun main() {
    val title = "Compose95 Demo"
    Window(
        undecorated = true,
        title = title,
        icon = ImageIO.read(Thread.currentThread().contextClassLoader.getResource("icon.png").openStream())
    ) {
        Window95(
            modifier = Modifier.fillMaxHeight(),
            headerTitle = title,
        ) {
            Column {
                Button95(onClick = { }) { Text("Hello, World") }
                Checkbox95 { }
            }
        }
    }
}