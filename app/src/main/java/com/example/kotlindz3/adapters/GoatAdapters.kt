package com.example.kotlindz3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindz3.databinding.GridLayoutItemBinding

class GoatAdapters(
    private var list: ArrayList<Int>
) : RecyclerView.Adapter<GoatAdapters.ItemHolder>() {
    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            GridLayoutItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ItemHolder(private var binding: GridLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(goatChar: Int) {
            binding.iconsImage.setImageResource(goatChar)

            itemView.setOnClickListener {
                if (binding.blackTint.visibility == View.GONE) {
                    binding.blackTint.visibility = View.VISIBLE
                    onItemClickListener.onSave(goatChar)
                } else {
                    binding.blackTint.visibility = View.GONE
                    onItemClickListener.onDelete(goatChar)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onSave(goatChar: Int)
        fun onDelete(goatChar: Int)
    }
}