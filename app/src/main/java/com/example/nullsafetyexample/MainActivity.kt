package com.example.nullsafetyexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nullsafetyexample.ui.theme.NullSafetyExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NullSafetyExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NullSafetyExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NullSafetyExample(modifier: Modifier = Modifier) {
    var properName: String = "Anders"
    //properName = null // Does not compile

    val name: String? = null
    val length: Int? = name?.length
    val length1: Int? = if (name == null) null else name.length

    val length2: Int = name?.length ?: -1
    val length3: Int = if (name == null) -1 else name.length

    val name2: String = name ?: "No Name"
    // so-called Elvis operator (Elvis Presley's hair style)
    val name22: String = if (name == null) "No Name" else name

    Column(modifier = modifier.padding(16.dp)) {
        Text("name = $name")
        Text("length = $length")
        Text("length1 = $length1")
        Text("length2 = $length2")
        Text("length3 = $length3")
        Text("name2 = $name2")
        Text("name2_2 = $name22")
        Text("properName = $properName")
    }
}

@Preview(showBackground = true)
@Composable
fun NullSafetyPreview() {
    NullSafetyExampleTheme {
        NullSafetyExample()
    }
}