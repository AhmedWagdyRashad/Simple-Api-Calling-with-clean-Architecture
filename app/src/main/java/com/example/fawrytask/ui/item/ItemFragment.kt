package com.example.fawrytask.ui.item

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
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
import androidx.navigation.fragment.navArgs
import com.example.domain.entity.Entry
import com.example.fawrytask.R
import com.example.fawrytask.databinding.FragmentItemBinding
import com.example.fawrytask.ui.dialog.SharingDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.fragment_item), SharingDialog.OnClickListener {
    val args by navArgs<ItemFragmentArgs>()
    private val viewModel by viewModels<ItemViewModel>()
    private var link = ""
    private val sharingDialog: SharingDialog by lazy {
        SharingDialog(requireContext(), this)
    }
    val TAG = "CategoryFragment"
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemsAdapter: ItemsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemBinding.bind(view)
        itemsAdapter = ItemsAdapter(object : ItemsAdapter.OnItemClickListener {
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

    private fun loadData() {
        viewModel.getItem(args.categoryType)
        binding.itemRv.adapter = itemsAdapter
        lifecycleScope.launch {
            viewModel.items.collect {
                binding.count.text = "Count: ${it?.count ?: 0}"
                itemsAdapter.submitList(it?.entries)
            }
        }
    }

    private fun crateMenu() {
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

    private fun showDialog(link: String) {
        if (!sharingDialog.isShowing) {
            sharingDialog.link = link
            sharingDialog.show()
        }
    }

    override fun onClick(phone: String, link: String) {
        if (validateNumber(number = phone)) {
            sharingDialog.dismiss()
            openWhatsApp(phone, link)
        } else {
            Toast.makeText(requireContext(), "please enter valid number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateNumber(number: String): Boolean =
        number.matches(Regex("^\\+[0-9]{10,13}\$"))


    private fun openWhatsApp(number: String, link: String) {
            val i = Intent(
                Intent.ACTION_VIEW, Uri.parse(
                    "https://api.whatsapp.com/send?phone=$number&text=$link"
                )
            )
            startActivity(i)
    }


}