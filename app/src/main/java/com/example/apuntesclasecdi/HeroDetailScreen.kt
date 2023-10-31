package com.example.apuntesclasecdi

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.apuntesclasecdi.heroes.HeroData

class HeroDetailScreen : ComponentActivity() {

    val nameText by lazy {findViewById<TextView>(R.id.detail_hero_title)}
    val descText by lazy {findViewById<TextView>(R.id.detail_hero_desc)}
    val backArrow by lazy {findViewById<ImageButton>(R.id.hero_detail_arrow)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hero_detail)

        var hero: HeroData?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hero = intent.getSerializableExtra("hero", HeroData::class.java)
        }else{
            hero = intent.getSerializableExtra("hero") as? HeroData
        }

        hero?.let{hero ->
            nameText.text = hero.name
            descText.text = hero.description
        }

        backArrow.setOnClickListener{
            finish()
        }

    }

}