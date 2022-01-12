package com.example.myuasapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myuasapp.R
import kotlinx.android.synthetic.main.recycler_row.view.*

class Adapter (
    val jaket : ArrayList<DataModel.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_row, parent ,false)
    )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data = jaket[position]
        holder.txtNama.text = data.nama
        holder.txtUkuran.text = data.ukuran
        holder.txtHarga.text = data.harga
    }

    override fun getItemCount()= jaket.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val txtNama = view.findViewById<TextView>(R.id.namaTextView)
        val txtUkuran = view.findViewById<TextView>(R.id.ukuranTextView)
        val txtHarga = view.findViewById<TextView>(R.id.hargaTextView)

    }

    public fun setData(data: List<DataModel.Data>){
        jaket.clear()
        jaket.addAll(data)
        notifyDataSetChanged()
    }
}