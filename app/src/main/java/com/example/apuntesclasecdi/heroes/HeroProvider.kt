package com.example.apuntesclasecdi.heroes

import com.example.apuntesclasecdi.heroes.Repositories.HeroRepository

class HeroProvider(val repository: HeroRepository) {

    suspend fun GetAllHeroes() : MutableList<HeroData> {
        return repository.GetHeroes()
    }
}