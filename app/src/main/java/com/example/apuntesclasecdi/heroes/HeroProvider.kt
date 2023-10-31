package com.example.apuntesclasecdi.heroes

import com.example.apuntesclasecdi.heroes.Repositories.HeroRepository

class HeroProvider(val repository: HeroRepository) {

    suspend fun GetPaginatedHeroes(currentOffset: Int, paginationSize: Int) : MutableList<HeroData> {
        return repository.GetHeroes(offset = currentOffset, limit = paginationSize)
    }
}