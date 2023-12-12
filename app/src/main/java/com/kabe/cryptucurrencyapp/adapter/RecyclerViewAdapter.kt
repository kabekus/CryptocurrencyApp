package com.kabe.cryptucurrencyapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kabe.cryptucurrencyapp.databinding.RowLayoutBinding
import com.kabe.cryptucurrencyapp.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList:ArrayList<CryptoModel>,private val listener:Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
    private val colors : Array<String> = arrayOf("#4b0082","#902e59","#99687f","#416aa3","#7d7eec","#6c6377")
    class RowHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cryptoModel: CryptoModel, colors:Array<String>,position:Int,listener:Listener){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))
            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener )
    }

}