package com.example.apuntesclasecdi.heroes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apuntesclasecdi.R

class HeroViewHolder(view: View) : ViewHolder(view) {

    val name by lazy{ view.findViewById<TextView>(R.id.hero_title)}
    val description by lazy{ view.findViewById<TextView>(R.id.hero_desc)}

    fun SetupWith(hero: HeroData){
        name.text = hero.name
        description.text = hero.description
    }
}