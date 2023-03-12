package com.example.fawrytask.ui.item

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Entry
import com.example.fawrytask.databinding.CategoryItemBinding

class ItemsAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Entry, ItemsAdapter.ViewHolder>(CategoryItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(categoryItem: Entry) {
            binding.apply {
                categoryNameTv.text = categoryItem.API
                binding.categoryDesTv.text = categoryItem.Description
                when (categoryItem.HTTPS) {
                    true -> {
                        binding.root.setBackgroundColor(Color.GRAY)
                    }
                    false -> {
                        binding.root.setBackgroundColor(Color.WHITE)
                    }
                }
            }
        }
    }

    class CategoryItemsDiffCallback : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(
            oldItem: Entry,
            newItem: Entry
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Entry,
            newItem: Entry
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Entry)
    }
}