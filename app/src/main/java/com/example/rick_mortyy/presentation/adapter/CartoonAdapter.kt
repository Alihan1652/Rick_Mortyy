package com.example.rick_mortyy.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyy.R
import com.example.rick_mortyy.domain.models.Character
import com.bumptech.glide.Glide

class CartoonAdapter : ListAdapter<Character, CartoonAdapter.VH>(Diff()) {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.characterImage)
        private val name: TextView = itemView.findViewById(R.id.characterName)
        private val status: TextView = itemView.findViewById(R.id.characterStatus)
        private val location: TextView = itemView.findViewById(R.id.characterLocation)
        private val episode: TextView = itemView.findViewById(R.id.characterEpisode)

        fun bind(item: Character) {
            name.text = item.name
            status.text = "${item.status} - ${item.species}"
            location.text = item.location.name
            episode.text = item.episode.firstOrNull() ?: "Unknown"

            Glide.with(image.context)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    class Diff : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem == newItem
    }
}