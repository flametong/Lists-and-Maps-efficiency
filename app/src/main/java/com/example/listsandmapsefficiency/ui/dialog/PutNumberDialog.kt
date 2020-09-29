package com.example.listsandmapsefficiency.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.listsandmapsefficiency.R
import com.example.listsandmapsefficiency.databinding.FragmentPutNumberDialogBinding
import com.example.listsandmapsefficiency.interfaces.NumberCallback

class PutNumberDialog : AppCompatDialogFragment() {

    private lateinit var binding: FragmentPutNumberDialogBinding
    private var callback: NumberCallback? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentPutNumberDialogBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(activity)

        binding.apply {
            builder.setView(root)
                .setTitle(R.string.enter_the_size)

            btnCalculate.setOnClickListener {
                val number = edNumber.text.toString().trim()
                if (number.isEmpty()) {
                    Toast.makeText(
                        context, R.string.enter_any_number,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    callback?.putNumber(number.toInt())
                    dismiss()
                }
            }

            btnCancel.setOnClickListener { dismiss() }
        }

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = context as NumberCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$context must implement NumberCallback"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }
}