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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.apuntesclasecdi.ui.theme.ApuntesClaseCDITheme

open class Fruit(val name: String = "Antifruta"){


}
class Apple(): Fruit("Manzana"){
    fun Applefunc(){

    }
}

class Banan(): Fruit("Baanan"){
    fun Babanfunc(){

    }
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesClaseCDITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(){

                        val fruits = listOf(Banan(), Apple(), null)

                        fruits.forEach{fruit ->
                            when(fruit){
                                is Banan -> {
                                    fruit.Babanfunc()
                                }

                                is Apple -> {
                                    fruit.Applefunc()
                                }

                                else -> {
                                    PrintScreen(name = "WTF chat, rarete")
                                }
                            }
                        }

                        val weekDay = "Lunes (Putada)"

                        when(weekDay){
                            "Lunes(Putada)" -> "Es martes"
                            "Martes" -> "AAAAAA"
                        }


                    }


                }
            }
        }
    }
}

@Composable
fun PrintScreen(name: String, modifier: Modifier = Modifier, color: Color? = null) {

    Text(
        text = "Hello ${name.uppercase()}",
        modifier = modifier,
        color = color ?: Color.Black
    )

}