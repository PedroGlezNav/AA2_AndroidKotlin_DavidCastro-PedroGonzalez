package com.example.apuntesclasecdi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apuntesclasecdi.ui.theme.ApuntesClaseCDITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesClaseCDITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrintScreen(null, null)
                }
            }
        }
    }
}

@Composable
fun PrintScreen(name: String?, name2: String?, modifier: Modifier = Modifier) {

    val name = name ?: run{
        Log.e("NULO", "ERES MALO")
        return
    }

    val name2 = name2 ?: run{
        Log.e("NULO2", "Y ADEMAS HUELES MAL")
        return
    }

    Text(
        text = "Hello ${name?.uppercase()}",
        modifier = modifier
    )

}