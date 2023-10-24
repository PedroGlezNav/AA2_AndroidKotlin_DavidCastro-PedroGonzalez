package com.example.apuntesclasecdi.heroes.Repositories

import com.example.apuntesclasecdi.heroes.HeroData

class HeroMockRepository : HeroRepository {
    companion object {
        private val heroListHardcoded = mutableListOf(
            HeroData("Aquaman", "Bobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Spoider Pig", "Hace lo que jarry popoter"),
            HeroData("Eran dos", "pero los cosieron"),
            HeroData("Shadow", "Damn, not here"),
            HeroData("Knuckles", "Hace todo lo que puede hacer una mujer"),
            HeroData("Tails", "Está arreglado, o no"),
            HeroData("Amy", "Yo soy una chica, haha"),
            HeroData("Silver", "There is no use")
        )

    }

    override suspend fun GetHeroes(): MutableList<HeroData> {
        return heroListHardcoded
    }
}