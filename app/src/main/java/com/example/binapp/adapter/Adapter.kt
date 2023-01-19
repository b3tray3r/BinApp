package com.example.binapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.binapp.R
import com.example.binapp.json.BinInfoItem


class Adapter : RecyclerView.Adapter<Adapter.BinViewHolder>() {

    private var bins: ArrayList<BinInfoItem> = arrayListOf()

    fun setBins(bins: BinInfoItem) {
        this.bins.add(bins)
        notifyDataSetChanged()
    }


    class BinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.itemText)

        fun bind(bin: BinInfoItem) {

            item.text = "Bank name: ${bin.bank?.name}\n" +
                    "Site: ${bin.bank?.url}\n" +
                    "Phone: ${bin.bank?.phone}\n" +
                    "Type: ${bin.type} \n" +
                    "Scheme/Network: ${bin.scheme}\n" +
                    "Country, Currency: ${bin.country?.name}/${bin.country?.currency}"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return BinViewHolder(view)
    }

    override fun getItemCount(): Int = bins.size

    override fun onBindViewHolder(holder: BinViewHolder, position: Int) {
        holder.bind(bins[position])
    }


}