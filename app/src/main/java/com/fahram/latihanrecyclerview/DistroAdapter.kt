package com.fahram.latihanrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fahram.latihanrecyclerview.databinding.DistroItemBinding

class DistroAdapter(
    private val listDistro: ArrayList<Distro>,
    private val onItemClick: (Distro) -> Unit
) :
    RecyclerView.Adapter<DistroAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: DistroItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = DistroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, origin, base, logo) = listDistro[position]
        holder.binding.tvName.text = name
        holder.binding.tvOrigin.text = origin
        holder.binding.tvBase.text = base
        holder.binding.ivLogo.setImageResource(logo)
        holder.itemView.setOnClickListener {
            onItemClick(listDistro[position])
        }
        holder.binding.btnFavorite.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "$name added to Favorite distros",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listDistro.size

}