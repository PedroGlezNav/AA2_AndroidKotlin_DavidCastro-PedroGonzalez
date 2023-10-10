package com.example.apuntesclasecdi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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

    class ButtonGrid;

    enum class Operation(private val operation: (a: Int, b: Int) -> Int, char: Char){
        Add({a,b -> a + b}, " + "),
        Sub({a,b -> a - b}," - ")),
        Mul({a,b -> a * b," * ")),
        Div({a,b -> a / b}," / "));

        public fun Operate(a: Int, b: Int) : Int{
            return this.operation(a,b)
        }
    }

    var A:Int? = null
    var B:Int? = null
    var Op:Operation? = null

    val result : TextView by lazy {findViewById(R.id.number)}
    val btncontainer : LinearLayout by lazy {findViewById(R.id.btncontainer)}

    fun OperationPress(op: Operation){
        if(A != null && B != null){
            Op = op
            result.text = A.toString() + op?.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val buttonGrid = ButtonGrid(this, btncontainer)

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "x"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ",", "<-", "="))

        for(y in names.indices){
            var row = buttonGrid.AddNewRow()

            for(x in names[y].indices){
                val bt = row.AddNewButton(names[y][x])

                bt.setOnClickListener{
                    when(names[y][x]){
                        "AC" ->{
                            A = null
                            B = null
                            Op = null
                            result.text ="Sad monke"
                        }
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->{
                            if(Op == null){
                                A?.let { a ->
                                    A = (a * 10) + names[y][x].toInt()
                                }?: run{
                                    A = names[y][x].toInt()
                                }
                            }else{
                                B?.let { b ->
                                    B = (b * 10) + names[y][x].toInt()
                                }?: run{
                                    B = names[y][x].toInt()
                                }
                            }
                        }
                        "+"->{
                            OperationPress(Operation.Add)
                        }
                        "-"->{
                            OperationPress(Operation.Sub)
                        }
                        "*"->{
                            OperationPress(Operation.Mul)
                        }
                        "/"->{
                            OperationPress(Operation.Div)
                        }
                        "="->{

                        }
                    }
                }
            }
        }



    }
}
