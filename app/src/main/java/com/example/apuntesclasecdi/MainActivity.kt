package com.example.apuntesclasecdi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclasecdi.heroes.HeroAdapter
import com.example.apuntesclasecdi.heroes.HeroData
import com.example.apuntesclasecdi.heroes.HeroProvider
import com.example.apuntesclasecdi.heroes.Repositories.HeroMockRepository
import com.example.apuntesclasecdi.heroes.Repositories.HeroSharedDatabase
import com.example.apuntesclasecdi.heroes.Repositories.HeroesAPIService
import com.example.apuntesclasecdi.utilBannan.SharedBannan
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val table by lazy{ findViewById<RecyclerView>(R.id.my_heros)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)
        //val repository = HeroSharedDatabase()
        //val repository = HeroesAPIService()

        val repository = HeroesAPIService()

        table.adapter = HeroAdapter(repository)



/*
        val provider = HeroProvider(repository)

        CoroutineScope(Dispatchers.IO).launch {
            val heroes = provider.GetAllHeroes()

            CoroutineScope(Dispatchers.Main).launch {
                table.adapter = HeroAdapter(heroes)
            }

        }
*/
    }
}
