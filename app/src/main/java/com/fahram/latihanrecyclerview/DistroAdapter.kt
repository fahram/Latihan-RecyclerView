package com.fahram.latihanrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DistroAdapter(private val listDistro: ArrayList<Distro>,
                    private val onItemClick: (Distro) -> Unit) :
    RecyclerView.Adapter<DistroAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivLogo: ImageView = itemView.findViewById(R.id.iv_logo)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvOrigin: TextView = itemView.findViewById(R.id.tv_origin)
        var tvBase: TextView = itemView.findViewById(R.id.tv_base)
        var btnFav: Button = itemView.findViewById(R.id.btn_favorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.distro_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, origin, base, logo) = listDistro[position]
        holder.tvName.text = name
        holder.tvOrigin.text = origin
        holder.tvBase.text = base
        holder.ivLogo.setImageResource(logo)
        holder.itemView.setOnClickListener {
            onItemClick(listDistro[position])
        }
        holder.btnFav.setOnClickListener {
            Toast.makeText(holder.itemView.context, "$name added to Favorite distros", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listDistro.size

}