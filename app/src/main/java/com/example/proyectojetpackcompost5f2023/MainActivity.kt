package com.example.proyectojetpackcompost5f2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectojetpackcompost5f2023.ui.theme.ProyectoJetPackCompost5F2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoJetPackCompost5F2023Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Replace Greeting with Suma
                    Suma()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Suma() {
    // Crear estados para almacenar los valores ingresados
    val num1 = remember { mutableStateOf("") }
    val num2 = remember { mutableStateOf("") }
    val resultado = remember { mutableStateOf("0") }

    // Crear una función para realizar la suma
    fun sumar() {
        val num1Int = num1.value.toIntOrNull() ?: 0
        val num2Int = num2.value.toIntOrNull() ?: 0
        val c = num1Int + num2Int

        resultado.value = "$num1Int + $num2Int = $c"
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {

        TextField(
            value = num1.value,
            onValueChange = { num1.value = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = num2.value,
            onValueChange = { num2.value = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { sumar() }) {
            Text("Sumar")
        }

        Text("Resultado: ${resultado.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoJetPackCompost5F2023Theme {
        // Use the Suma composable for the preview
        Suma()
    }
}
