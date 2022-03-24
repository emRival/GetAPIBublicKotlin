package com.rival.getapipublic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rival.getapipublic.R
import com.rival.getapipublic.response.DataItem

class AnimeAdapter(val dataAnime : List<DataItem?>?) : RecyclerView.Adapter<AnimeAdapter.MyViewHolder>(){
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgAnime = view.findViewById<ImageView>(R.id.img_row)
        val judulAnime = view.findViewById<TextView>(R.id.tv_row)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.judulAnime.text = dataAnime?.get(position)?.animeName

        Glide.with(holder.imgAnime)
            .load(dataAnime?.get(position)?.animeImg)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgAnime)

        holder.itemView.setOnClickListener {
            val name = dataAnime?.get(position)?.animeName
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        if (dataAnime != null){
            return dataAnime.size
        }
        return 0
    }
}