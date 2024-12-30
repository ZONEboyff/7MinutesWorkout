package com.example.a7minutesworkout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minutesworkout.databinding.ItemHistoryRowBinding

class HistoryAdapter(private val items: ArrayList<String>):RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(binding:ItemHistoryRowBinding):RecyclerView.ViewHolder(binding.root) {
        val llHistoryItemMain = binding.llHistoryItemMain
        val tvPosition = binding.tvPosition
        val tvItem = binding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun getItemCount(): Int {
        return items.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvPosition.text = (position+1).toString()
        holder.tvItem.text = items[position]
        if(position%2==0){
            holder.llHistoryItemMain.setBackgroundColor(holder.llHistoryItemMain.resources.getColor(R.color.lightGrey))
        }else{
            holder.llHistoryItemMain.setBackgroundColor(holder.llHistoryItemMain.resources.getColor(R.color.white))
        }
    }
}