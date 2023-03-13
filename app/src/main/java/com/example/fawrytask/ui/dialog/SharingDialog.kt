package com.example.fawrytask.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.fawrytask.R
import com.example.fawrytask.databinding.SharingDialogBinding

class SharingDialog(
    private val mContext: Context,
    private val listener: OnClickListener,
    var link: String = ""
) : Dialog(mContext) {

    private var _binding: SharingDialogBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = SharingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window!!.setGravity(Gravity.CENTER)
        setCancelable(false)
        initializeComponents()
    }

    private fun initializeComponents() {
        binding.cancelBtn.setOnClickListener {
            binding.numberEdt.setText("")
            dismiss()
        }
        binding.shareBtn.setOnClickListener {
            binding.numberEdt.text?.let {
                listener.onClick(it.toString().trim(), link)
            }
            binding.numberEdt.setText("")
        }
    }
    override fun onStop() {
        super.onStop()
    }

    interface OnClickListener {
        fun onClick(phone: String, link: String)
    }

}