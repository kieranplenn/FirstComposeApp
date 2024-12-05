package com.example.firstcomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // A new version of the set content, NO MORE LAYOUTS, takes a lambda
        setContent {
            FirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var counter by rememberSaveable { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {counter++}
        ) { Text("Increase") }

        Text(
            counter.toString(),
            fontSize = 64.sp
        )


        Button(
            onClick = {counter--}
        ) { Text("Decrease") }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstComposeAppTheme {
        Counter()
    }
}