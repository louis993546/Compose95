package com.louis993546.compose95

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.louis993546.compose95.components.Button95
import com.louis993546.compose95.components.Window95

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo()
        }
    }
}

@Composable
fun Demo() {
    Window95(
        modifier = Modifier.fillMaxHeight(),
        headerTitle = "compose95.exe"
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Greeting("Android")
            Button95(modifier = Modifier.padding(4.dp), onClick = {}) {
                Text("Click me")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Demo()
}