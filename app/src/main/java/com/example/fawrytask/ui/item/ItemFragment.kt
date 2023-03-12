package com.example.fawrytask.ui.item

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.domain.entity.Entry
import com.example.fawrytask.R
import com.example.fawrytask.databinding.FragmentItemBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.fragment_item) {
    val args by navArgs<ItemFragmentArgs>()
    private val viewModel by viewModels<ItemViewModel>()
    val TAG = "CategoryFragment"
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemsAdapter:ItemsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemBinding.bind(view)
         itemsAdapter = ItemsAdapter(object: ItemsAdapter.OnItemClickListener{
            override fun onItemClick(item: Entry) {
               showDialog(item.Link)
            }
        })
        loadData()
        crateMenu()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun loadData(){
        viewModel.getItem(args.categoryType)
        binding.itemRv.adapter = itemsAdapter
        lifecycleScope.launch {
            viewModel.items.collect{
                binding.count.text = "Count: ${it?.count?:0}"
                itemsAdapter.submitList(it?.entries)
            }
        }
    }
    private fun crateMenu(){
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_retry, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_retry -> {
                        loadData()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
    private fun showDialog(link:String){

    }
}