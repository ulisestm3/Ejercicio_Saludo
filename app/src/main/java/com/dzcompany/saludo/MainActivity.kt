package com.dzcompany.saludo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dzcompany.saludo.ui.theme.SaludoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaludoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MiComposable()
                }
            }
        }
    }
}

@Composable
fun MiComposable(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var saludo by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Dime tu nombre: ")

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it},
            label = { Text("ejemplo: Ulises") },
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { saludo = true }
        ) {
            Text(text = "Saludar")
        }

        if(nombre.isNotEmpty() && saludo) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hola $nombre")
        }else{
            Text(text = "No has escrito nada")
        }

    }
}