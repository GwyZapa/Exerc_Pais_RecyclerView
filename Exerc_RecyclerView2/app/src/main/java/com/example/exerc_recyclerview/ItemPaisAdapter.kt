package com.example.exerc_recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exerc_recyclerview.databinding.ListCardViewBinding

class ItemPaisAdapter()  :
    RecyclerView.Adapter<ItemPaisAdapter.ItemLineViewHolder>(){

    private val items: MutableList<ItemPaisModel> = mutableListOf()

    class ItemLineViewHolder(val itemHolder: ListCardViewBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item: ItemPaisModel) {
            itemHolder.txtContinente.text = item.continente
            itemHolder.txtPais.text = item.nome
        }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLineViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemLineViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}