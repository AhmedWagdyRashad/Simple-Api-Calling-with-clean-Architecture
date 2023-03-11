package com.example.fawrytask.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fawrytask.databinding.CategoryItemBinding

class CategoryAdapter(private val onCategoryClickListener:OnCategoryClickListener) :
    ListAdapter<String, CategoryAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onCategoryClickListener.onClicked(getItem(position))
        }
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: String) {
            itemBinding.apply {
                categoryNameTv.text = category
           // itemBinding.categoryDesTv.text = category.strCategoryDescription
           // Glide.with(itemBinding.root.context).load(category.link).into(itemBinding.categoryIv)
        }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<String>() {
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
    interface OnCategoryClickListener{
        fun onClicked(item: String)
    }
}