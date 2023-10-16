package com.example.apuntesclasecdi.utilBannan

import android.content.Context
import android.content.SharedPreferences
import com.example.apuntesclasecdi.MyApp

typealias banan = SharedBannan

object SharedBannan {
    private const val MyBannanName = "MySharedPreferencesStorage"

    private val shared: SharedPreferences by lazy{ MyApp.Context.getSharedPreferences(MyBannanName, Context.MODE_PRIVATE)}
    private val editor: SharedPreferences.Editor by lazy{ shared.edit()}

    private const val TimesOpenAppKey = "AppOpenTimes"

    public var TimesOpenApp: Int
        get() = shared.getInt(TimesOpenAppKey, 0)
        set(value){
            editor.putInt(TimesOpenAppKey, value)
            editor.apply()
        }

}

/*
       val shared = this.getSharedPreferences("MySharedPreferencesStorage", Context.MODE_PRIVATE)

       //base de datos mal, para apps pequeñas ok
       var timesOpenApp = shared.getInt("AppOpenTimes", 0)

       timesOpenApp++

       openTimesAppText.text = timesOpenApp.toString()

       val editor = shared.edit()

       editor.putInt("AppOpenTimes", timesOpenApp)
       editor.apply()*/