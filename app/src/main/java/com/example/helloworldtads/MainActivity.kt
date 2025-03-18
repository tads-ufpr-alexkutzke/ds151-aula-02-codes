package com.example.helloworldtads

import android.util.Log
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworldtads.ui.theme.HelloWorldTADSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTADSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded: MutableState<Boolean> = remember { mutableStateOf(false) }
    Surface( color = MaterialTheme.colorScheme.secondary, modifier = modifier.padding(4.dp) ) {
        Row(modifier = modifier.padding(24.dp)){
            Column(modifier = modifier.padding(4.dp).weight(0.8F)){
                Text(
                    text = "Hello",
                )
                Text(
                    text = "${name}!",
                )
            }
            ElevatedButton(
                modifier = modifier.weight(1.0F),
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                Text(if (expanded.value) stringResource(R.string.button_label_less) else stringResource(R.string.button_label_more))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTADSTheme {
        Greeting("Android")
    }
}