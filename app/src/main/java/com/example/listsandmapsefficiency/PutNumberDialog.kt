package com.example.listsandmapsefficiency

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.listsandmapsefficiency.databinding.FragmentPutNumberDialogBinding

class PutNumberDialog : AppCompatDialogFragment() {

    private lateinit var binding: FragmentPutNumberDialogBinding

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
                    // TODO: passData()
                }
                dismiss()
            }
        }

        return builder.create()
    }
}