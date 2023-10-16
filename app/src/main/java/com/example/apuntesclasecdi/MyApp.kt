package com.example.apuntesclasecdi

import android.app.Application
import android.content.Context

class MyApp: Application() {

    companion object{
        private lateinit var instance:MyApp

        //Si quisieramos restringir que devuelva el ultime contexto, se puede hacer, pero jajasi
        public val Context: MyApp get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}