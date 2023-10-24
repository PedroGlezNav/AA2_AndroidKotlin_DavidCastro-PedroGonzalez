package com.example.apuntesclasecdi.heroes.Repositories

import com.example.apuntesclasecdi.heroes.HeroData
import com.example.apuntesclasecdi.utilBannan.SharedBannan

class HeroSharedDatabase : HeroRepository {

    override suspend fun GetHeroes(): MutableList<HeroData> {
        return SharedBannan.Heroes
    }
}