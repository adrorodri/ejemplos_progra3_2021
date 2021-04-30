package com.adrorodri.ejemplosprogra32021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductListRecyclerViewAdapter(val listaProductos: List<Producto>): RecyclerView.Adapter<ViewHolder>() {

    var clickListener: ((product: Producto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item_producto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaProductos.get(position))
        holder.itemView.setOnClickListener {
            clickListener?.invoke(listaProductos.get(position))
        }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    fun setOnProductItemClickListener(productClickListener: (product: Producto) -> Unit) {
        clickListener = productClickListener
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(product: Producto) {
        itemView.findViewById<TextView>(R.id.textViewProductItem).text = product.nombre
        itemView.findViewById<ImageView>(R.id.imageViewProductItem).setImageResource(product.imagen)
    }
}