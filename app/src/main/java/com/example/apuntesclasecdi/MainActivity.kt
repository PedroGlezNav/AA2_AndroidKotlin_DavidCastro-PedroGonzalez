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

enum class Colors(val color: Color, val tranlationKey: String){
    Red(Color.Red, "Color_Key_Red"),
    Green(Color.Green,"Color_Key_Green"),
    Blue(Color.Blue,"Color_Key_Blue"),

    /*fun GetColor() : Color {
        when(this){
            Red -> Color.Red
            Green -> Color.Green
            Blue -> Color.Blue
        }

        return Color.Black;
    }*/
}

enum class Operations(val operation: (Int, Int) -> Int, val priority: Int){
    Add({a,b -> a + b}, 0),
    Subtract({a,b -> a - b}, 0);

    fun Calculate(a: Int, b: Int): Int {
        return this.operation(a,b)
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
                        var color = Colors.Green
                        color.color

                        PrintScreen(color.tranlationKey, color = color.color)

                        val operation = Operations.Add
                        val result = operation.Calculate(1, 2)

                        PrintScreen(name = result.toString())
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