package com.example.exerc_recyclerview

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.exerc_recyclerview.databinding.PopupItemDialogBinding

class PopupDialogItem : DialogFragment() {
    lateinit var bind: PopupItemDialogBinding
    var iDialogInterface: IDialogItem? = null
    private var itemPosition: Int = -1


    override fun onCreateDialog(savedInstaceState: Bundle?): Dialog {
        bind = PopupItemDialogBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(bind.root)
            .setPositiveButton("Confirma") { dialog, _ ->

                val popupItem = ItemPaisModel(
                    bind.txtPais.text.toString(),
                    bind.txtContinente.text.toString(),
                    true
                )
                iDialogInterface?.addItem(
                    popupItem
                )


                dialog.cancel()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }


        return builder.create()
    }

    companion object {
        fun buildDialog(iDialog: IDialogItem, posicao: Int = -1): PopupDialogItem {
            val args = Bundle()
            val dialog = PopupDialogItem()
            dialog.arguments = args
            dialog.iDialogInterface = iDialog
            dialog.itemPosition = posicao
            Log.d("PopupDialogItem", "Building dialog with position: $posicao")
            return dialog
        }
    }

}