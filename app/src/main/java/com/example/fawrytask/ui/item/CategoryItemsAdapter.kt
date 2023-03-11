package com.example.fawrytask.ui.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fawrytask.databinding.CategoryItemBinding

class CategoryItemsAdapter(private val onItemClickListener:OnItemClickListener) :
    ListAdapter<String, CategoryItemsAdapter.ViewHolder>(CategoryItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onItemClickListener.onClicked(getItem(position))
        }
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(categoryItem: String) {
            itemBinding.apply {
                categoryNameTv.text = categoryItem
           // itemBinding.categoryDesTv.text = category.strCategoryDescription
           // Glide.with(itemBinding.root.context).load(category.link).into(itemBinding.categoryIv)
        }
        }
    }

    class CategoryItemsDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    interface OnItemClickListener{
        fun onClicked(item: String)
    }
}