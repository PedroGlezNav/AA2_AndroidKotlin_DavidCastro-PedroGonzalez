package com.example.apuntesclasecdi.heroes

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.apuntesclasecdi.HeroDetailScreen
import com.example.apuntesclasecdi.R
import com.example.apuntesclasecdi.heroes.Repositories.HeroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroAdapter(private val repository: HeroRepository, private val paginationSize: Int = 20) : Adapter<HeroViewHolder>() {

    private val provider: HeroProvider = HeroProvider(repository)
    private var heroList: MutableList<HeroData> = mutableListOf()
    private var requestingData = false

    init {
        GetMoreData()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val viewHolder = HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))

        viewHolder.itemView.setOnClickListener{
            val intent = Intent(parent.context, HeroDetailScreen::class.java)
            intent.putExtra("hero",viewHolder.hero)

            parent.context.startActivity(intent)
        }

        return viewHolder
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetupWith(heroList[position])
        if(position >= heroList.size - paginationSize){
            GetMoreData()
        }
    }

    fun GetMoreData(){

        if(requestingData) return

        requestingData = true

        CoroutineScope(Dispatchers.IO).launch {

            var extraHeroes = provider.GetPaginatedHeroes(currentOffset = heroList.size, paginationSize)

            CoroutineScope(Dispatchers.Main).launch {

                heroList.addAll(extraHeroes)

                notifyDataSetChanged()

                requestingData = false
            }

        }
    }
}