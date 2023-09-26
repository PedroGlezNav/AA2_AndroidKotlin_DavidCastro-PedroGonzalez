package com.example.apuntesclasecdi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apuntesclasecdi.ui.theme.ApuntesClaseCDITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesClaseCDITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(){

                        for(i in 1 .. 5){
                            PrintScreen(null)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        val names = listOf("Pedro", "David");

                        for(name in names) {
                            PrintScreen(name)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        for(i in names.indices){
                            //PrintScreen(names.indexOf(i))
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        names.forEach{name -> PrintScreen(name)}

                        Spacer(modifier = Modifier.height(16.dp))

                        //names.forEachIndexed{1 name -> PrintScreen()}

                    }


                }
            }
        }
    }
}

@Composable
fun PrintScreen(name: String?, modifier: Modifier = Modifier) {

    val name = name ?: run{
        Log.e("NULO", "ERES MALO")
        return
    }

    /*val name2 = name2 ?: run{
        Log.e("NULO2", "Y ADEMAS HUELES MAL")
        return
    }*/

    Text(
        text = "Hello ${name?.uppercase()}",
        modifier = modifier
    )

}