package com.example.exerc_recyclerview

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.exerc_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IDialogItem {

    private lateinit var bind: ActivityMainBinding
    private val adapter = ItemPaisAdapter( this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.itensRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        bind.itensRecycler.adapter = adapter


        adapter.setList(
            mutableListOf(
                ItemPaisModel(
                    "BRASIL",
                    "América do Sul",
                    true
                ),
                ItemPaisModel(
                    "ARGENTINA",
                    "América do Sul",
                    true
                ),
                ItemPaisModel(
                    "PERU",
                    "América do Sul",
                    true
                )
            )
        )

        bind.buttonAddPais.setOnClickListener {
            PopupDialogItem.buildDialog(this).show(supportFragmentManager, "ADDDIALOG")
        }
    }


    override fun addItem(item: ItemPaisModel) {
        Log.d("MainActivity", "Adding item: $item")
        adapter.addListItem(item)
    }


    override fun removeItem(item: ItemPaisModel) {
        val confirmDialog = AlertDialog.Builder(this)
        confirmDialog.setTitle("Exclusao")
        confirmDialog.setMessage("Confirma a exclusão do ${item.nome}")
        confirmDialog.setPositiveButton("Sim") { dialog, _ ->
            adapter.removeItem(item)
            dialog.cancel()
        }
        confirmDialog.setNegativeButton("Não") { dialog, _ ->
            dialog.cancel()
        }
        confirmDialog.show()
    }
}