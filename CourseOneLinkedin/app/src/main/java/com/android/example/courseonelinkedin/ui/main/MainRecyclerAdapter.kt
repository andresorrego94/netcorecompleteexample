package com.android.example.courseonelinkedin.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.courseonelinkedin.R
import com.android.example.courseonelinkedin.data.Monster
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.monster_grid_item.view.*

class MainRecyclerAdapter(val context: Context,
                          val monsters: List<Monster>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return monsters.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.monster_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monster = monsters[position]
        with(holder){
            nameText?.let {
                it.text = monster.name
                it.contentDescription = monster.name
            }
            ratingBar?.rating = monster.scariness.toFloat()
            Glide.with(context)
                .load(monster.thumbnailUrl)
                .into(monsterImage)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        val monsterImage = itemView.findViewById<ImageView>(R.id.monsterImage)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
    }

}