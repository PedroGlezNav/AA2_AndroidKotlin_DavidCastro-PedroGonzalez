package com.example.apuntesclasecdi

import android.content.Context
import android.content.Intent
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
import com.example.apuntesclasecdi.utilBannan.SharedBannan
import com.example.apuntesclasecdi.utilBannan.banan

class MainActivity : ComponentActivity() {

    val changeScreenBt by lazy{ findViewById<Button>(R.id.change_screen_bt)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        changeScreenBt.setOnClickListener{
            val newIntent = Intent(this, MainActivity2::class.java)

            //se pone el this porque somos tontos y nos han dado por culo
            this.startActivity(newIntent)
        }

}}
