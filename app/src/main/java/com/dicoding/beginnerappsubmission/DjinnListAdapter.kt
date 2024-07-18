package com.dicoding.beginnerappsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DjinnListAdapter (private val djinnList: ArrayList<ListofDjinn>) : RecyclerView.Adapter<DjinnListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_djinns,parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = djinnList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description,tagline,location,photo) = djinnList[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        //Intent 4 moving to detail page
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailedDjinnPage::class.java)
            intentDetail.putExtra("key_object",djinnList[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}