package com.example.binapp.adapter


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.binapp.R
import com.example.binapp.json.BinInfoItem



class Adapter() : RecyclerView.Adapter<Adapter.BinViewHolder>() {

    var bins: ArrayList<BinInfoItem> = arrayListOf()
    fun setBins(bins: BinInfoItem) {
        this.bins.add(bins)
        notifyDataSetChanged()

    }

    class BinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var bankName: TextView = itemView.findViewById(R.id.itemBank)
        val bankUrl: TextView = itemView.findViewById(R.id.itemBankUrl)
        val bankPhone: TextView = itemView.findViewById(R.id.itemBankPhone)
        val bankOther: TextView = itemView.findViewById(R.id.itemBankOther)
        val bankCountry: TextView = itemView.findViewById(R.id.itemBankCountry)
        val bankCurrency: TextView = itemView.findViewById(R.id.itemBankCurrency)


        fun bind(bin: BinInfoItem) {
            bankName.text = "Bank name: ${bin.bank?.name}"
            bankUrl.text = bin.bank?.url
            bankPhone.text = bin.bank?.phone
            bankOther.text = "Type: ${bin.type} \n" +
                    "Scheme/Network: ${bin.scheme}"
            bankCountry.text = bin.country?.name
            bankCurrency.text = bin.country?.currency
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return BinViewHolder(view)
    }

    override fun getItemCount(): Int = bins.size

    override fun onBindViewHolder(holder: BinViewHolder, position: Int) {
        holder.bind(bins[position])

        holder.bankPhone.setOnClickListener {
            val context = holder.bankPhone.context
            val callIntent = Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + holder.bankPhone.text)
            )
            context.startActivity(callIntent)
        }

        holder.bankUrl.setOnClickListener {
            val context = holder.bankUrl.context
            val webIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://" + holder.bankUrl.text.toString()))
            context.startActivity(webIntent)
        }

        holder.bankCountry.setOnClickListener {
            val context = holder.bankCountry.context
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=${holder.bankCountry.text}"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }
            context.startActivity(mapIntent)
        }

    }
}