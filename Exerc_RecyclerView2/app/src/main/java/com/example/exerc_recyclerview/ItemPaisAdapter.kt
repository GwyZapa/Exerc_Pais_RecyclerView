package com.example.exerc_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exerc_recyclerview.databinding.ListCardViewBinding

class ItemPaisAdapter(private val dialogListener: IDialogItem) :
    RecyclerView.Adapter<ItemPaisAdapter.ItemLineViewHolder>() {

    private val items: MutableList<ItemPaisModel> = mutableListOf()

    class ItemLineViewHolder(val itemHolder: ListCardViewBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {

        fun bind(item: ItemPaisModel) {
            itemHolder.txtContinente.text = item.continente
            itemHolder.txtPais.text = item.nome
//            itemHolder.cardPais.visibility =
//                if (item.detailVisibility) View.VISIBLE else View.GONE

            // Define os ícones com base no continente
            when (item.continente) {
                "América do Sul" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_americas)
                "América do Norte" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_americas)
                "América Central" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_americas)
                "Europa" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_europa)
                "Asia" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_asia)
                "Africa" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_africa)
                "Oceania" -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag_oceania)
                else -> itemHolder.flagImage.setImageResource(R.drawable.icon_flag)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLineViewHolder {
        return  ItemLineViewHolder(
            ListCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItemLineViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemHolder.removeBtn.setOnClickListener{
            dialogListener.removeItem(items[position])
        }

        holder.itemHolder.cardPais.setOnClickListener {
            items[position].detailVisibility = !items[position].detailVisibility
            notifyItemChanged(position)
        }

    }

    fun addListItem(newItem: ItemPaisModel) {
        items.add(newItem)
        notifyItemInserted(items.size - 1) // Notify the adapter of the new item
    }
    fun setList(newItems: List<ItemPaisModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun removeItem(removed:ItemPaisModel){
        val removedIndex = items.indexOf(removed)
        items.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, items.size)
    }
}