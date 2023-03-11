package com.example.fawrytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fawrytask.databinding.ActivityMainBinding
import com.example.fawrytask.ui.category.CategoryAdapter
import com.example.fawrytask.ui.category.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivityCategory"
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG, "onCreate:>>>>>>>> it")
        viewModel.getCategory()
        val categoryAdapter = CategoryAdapter(object: CategoryAdapter.OnCategoryClickListener{
            override fun onClicked(item: String) {
                Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
            }
        })
        lifecycleScope.launch {
            viewModel.categories.collect{
   //             categoryAdapter.submitList(it?.categories)
                Log.i(TAG, "onCreate:>>>> ${it}")
                binding.categoryRv.adapter = categoryAdapter
            }
        }

    }
}