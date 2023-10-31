package com.example.apuntesclasecdi.heroes.Repositories

import com.example.apuntesclasecdi.heroes.HeroData
import com.example.apuntesclasecdi.utilBannan.SharedBannan

class HeroSharedDatabase : HeroRepository {

    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {

        val heroes = SharedBannan.Heroes

        if(heroes.size <= offset)
            return mutableListOf()

        if(heroes.size <= offset + limit)
            return heroes.subList(offset, heroes.size - 1)

        return heroes.subList(offset, limit)
    }
}