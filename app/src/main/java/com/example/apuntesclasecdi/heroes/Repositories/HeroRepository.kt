package com.example.apuntesclasecdi.heroes.Repositories

import com.example.apuntesclasecdi.heroes.HeroData

interface HeroRepository {
    suspend fun GetHeroes(offset: Int, limit: Int) : MutableList<HeroData>
}