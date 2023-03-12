package com.example.fawrytask.ui.category

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fawrytask.R
import com.example.fawrytask.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {
    private val viewModel by viewModels<CategoryViewModel>()
    val TAG = "CategoryFragment"
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCategoryBinding.bind(view)
         categoryAdapter = CategoryAdapter(object: CategoryAdapter.OnItemClickListener{
            override fun onItemClick(item: String) {
                val action = CategoryFragmentDirections.actionCategoryFragmentToItemFragment(item)
                findNavController().navigate(action)
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
        viewModel.getCategory()
        binding.categoryRv.adapter = categoryAdapter
        lifecycleScope.launch {
            viewModel.categories.collect{
                binding.count.text = "Count: ${it?.count?:0}"
                categoryAdapter.submitList(it?.categories)
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
}