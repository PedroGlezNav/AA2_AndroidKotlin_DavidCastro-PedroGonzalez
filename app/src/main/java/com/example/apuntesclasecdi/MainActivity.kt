package com.example.apuntesclasecdi

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.widget.doBeforeTextChanged
import com.example.apuntesclasecdi.ui.theme.ApuntesClaseCDITheme

class MainActivity : ComponentActivity() {

    val testBt by lazy{ findViewById<Button>(R.id.test_bt)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        testBt.setOnClickListener{
            val b = AlertDialog.Builder(this)

            b.setTitle("Seras mi angulo, o mi villaino?")
            //b.setMessage("HA, broma !")

            b.setPositiveButton("Hay que matar a esas criaturas negras!"){ dialog, which ->
                dialog.dismiss()
            }

            b.setNegativeButton("DAMN, NOT HERE"){ dialog, which ->
                dialog.dismiss()
            }

            b.setNeutralButton("No tengo opiniones a favor ni en contra de nada"){dialog , which ->
                dialog.dismiss()
            }

            val options = arrayOf("Azul", "7", "Zapato", "Panes Fehacientes")
            val selectedItems = booleanArrayOf(false, false, false, false)

            b.setMultiChoiceItems(options, selectedItems){dialog, which, isChecked ->
                selectedItems[which] = isChecked
            }

            b.setOnCancelListener{
                val toast = Toast(this)
                toast.setText("ITS NO USE")
                toast.show()
            }

            val linear = LinearLayout(this)
            linear.orientation = LinearLayout.VERTICAL

            val input = EditText(this)
            input.hint = "Incluye aqui tu badfic de wolfurra"

            val input2 = EditText(this)
            input2.hint = "Escribe el numero de bugs del sonic 06"

            linear.addView(input)
            linear.addView(input2)

            b.setView(linear)

            val dialog = b.create()
            dialog.show()
        }
    }
}
