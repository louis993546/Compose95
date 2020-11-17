import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import components.Button95
import components.Window95

fun main() = Window(undecorated = true) {
    Window95(
        modifier = Modifier.fillMaxHeight(),
        headerTitle = "Title",
    ) {
        Button95(onClick = {}) {
            Text("Hello, World")
        }
    }
}