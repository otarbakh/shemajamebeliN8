package com.example.shemajamebelin8.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebelin8.databinding.ItemsLayoutBinding
import com.example.shemajamebelin8.models.SuitsResponse


class SuitsAdapter: ListAdapter<SuitsResponse, ShmotkebiAdapter.ShmotkebiViewHolder>(TeamsDiffCallBack()) {



    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ShmotkebiViewHolder {
        val binding =
            ItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShmotkebiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShmotkebiViewHolder, position: Int) {
        holder.bindData()
    }


    inner class ShmotkebiViewHolder(private val binding: ItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: SuitsResponse? = null
        fun bindData() {
            model = getItem(bindingAdapterPosition)
            binding.apply {
                tvTitle.text = model?.title
                tvPrice.text = model?.price

                Glide.with(this.ivImage)
                    .load(model?.cover)
                    .into(ivImage)
            }
        }

    }
}
class TeamsDiffCallBack : DiffUtil.ItemCallback<SuitsResponse>() {
    override fun areItemsTheSame(oldItem: SuitsResponse, newItem: SuitsResponse): Boolean {
        return oldItem.title == newItem.title
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: SuitsResponse, newItem: SuitsResponse
    ): Boolean {
        return oldItem == newItem
    }
}