package com.github.masoudmahmoodzadeh.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.github.masoudmahmoodzadeh.movieapp.databinding.ItemTvShowBinding
import com.github.masoudmahmoodzadeh.movieapp.models.Item


class TvShowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return TvShowViewHolder(
            ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = tvShows[position]

        (holder as TvShowViewHolder).binding.apply {
            tvName.text = item.title
            tvDirector.text = item.getDirector()
            tvYear.text = item.year
            tvRate.text = "(".plus(item.imDbRating.plus(")"))
            ratingbar.rating = item.imDbRating.toFloat() / 2

            Glide.with(holder.itemView.context)
                .load(item.image)
                .transform(CenterInside(), RoundedCorners(32))
                .into(ivImage)

        }
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    inner class TvShowViewHolder(var binding: ItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var diffCallback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<Item>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }
}