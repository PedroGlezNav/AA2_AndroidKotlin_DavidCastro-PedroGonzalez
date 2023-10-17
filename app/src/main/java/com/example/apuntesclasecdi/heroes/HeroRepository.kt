package com.example.apuntesclasecdi.heroes

class HeroRepository {

    companion object {
        private val heroListHardcoded = listOf(
            HeroData("Aquaman", "Bobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo"),
            HeroData("Superman", "Superbobo")
        )

        fun GetAllHeroes(): List<HeroData> = heroListHardcoded
    }

}