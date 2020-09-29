package com.example.listsandmapsefficiency.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.listsandmapsefficiency.databinding.DialogProgressBarBinding
import java.io.Serializable

class LoadingDialog : DialogFragment(), Serializable {

    private lateinit var binding: DialogProgressBarBinding
    private var isShown = false

    companion object {
        fun newInstance(): LoadingDialog {
            val args = Bundle()
            val fragment = LoadingDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogProgressBarBinding.inflate(LayoutInflater.from(context))

        return AlertDialog.Builder(activity).apply {
            setCancelable(true)
            setView(binding.root)
        }.create()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (isShown) return
        super.show(manager, tag)
        isShown = true
    }

    override fun dismiss() {
        isShown = false
        super.dismiss()
    }

    fun getShownStatus(): Boolean =
        isShown

}