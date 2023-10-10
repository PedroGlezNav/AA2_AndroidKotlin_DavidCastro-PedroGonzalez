package com.example.apuntesclasecdi;


import android.content.Context
import android.view.ViewParent
import android.widget.Button
import android.widget.LinearLayout;

public class ButtonGrid(val context: Context, val parent: LinearLayout) {

    class ButtonsRow(val context: Context, val parent: LinearLayout){
        var buttons : MutableList<Button> = mutableListOf()
        val  linearLayout: LinearLayout = LinearLayout(context)

        init {
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
            )

            linearLayout.setBackgroundColor(context.getColor(R.color.teal_200))

            parent.addView(linearLayout)
        }

        fun AddNewButton(text: String) : Button{
            var bt = Button(context)
            bt.text = text

            bt.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1.0f
            )

            linearLayout.addView(bt)
            buttons.add(bt)

            return bt
        }
    }



    private val rows: MutableList<ButtonsRow> = mutableListOf();

    fun AddNewRow() : ButtonsRow {

        val btRow = ButtonsRow(context, parent)

        rows.add(btRow)

        return btRow

    }

    fun GetRow(index: Int) : ButtonsRow?{
        if(index >= rows.count() || index < 0){
            return null
        }

        return rows[index]
    }
}