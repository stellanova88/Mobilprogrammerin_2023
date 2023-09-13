package com.example.playingwithnavigation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen (login: () -> Unit){
    var password by remember { mutableStateOf("pass")}
    
    Column {
        OutlinedTextField(value = "Username", onValueChange = {})
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        Button(onClick = { login() }) {
            Text(text = "Login")
            
        }
    }
}

@Preview
@Composable
fun LoginPreivew() {
    LoginScreen( login = {})
}