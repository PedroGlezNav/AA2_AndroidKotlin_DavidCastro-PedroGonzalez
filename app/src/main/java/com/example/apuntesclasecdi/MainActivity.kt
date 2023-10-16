package com.example.apuntesclasecdi

import android.content.Context
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

    val openTimesAppText by lazy { findViewById<TextView>(R.id.open_app_times_text)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        /*
        val shared = this.getSharedPreferences("MySharedPreferencesStorage", Context.MODE_PRIVATE)

        //base de datos mal, para apps pequeñas ok
        var timesOpenApp = shared.getInt("AppOpenTimes", 0)

        timesOpenApp++

        openTimesAppText.text = timesOpenApp.toString()

        val editor = shared.edit()

        editor.putInt("AppOpenTimes", timesOpenApp)
        editor.apply()*/

        banan.TimesOpenApp--
        openTimesAppText.text = banan.TimesOpenApp.toString()

    }
}
