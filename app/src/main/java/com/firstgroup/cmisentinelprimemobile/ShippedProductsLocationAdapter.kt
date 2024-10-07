package com.firstgroup.cmisentinelprimemobile
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class ShippedProductsByLocationAdapter(private val shippedProducts: List<ShippedProductsByLocation>) :
    RecyclerView.Adapter<ShippedProductsByLocationAdapter.ShippedProductViewHolder>() {

    class ShippedProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val locationIcon: ImageView = itemView.findViewById(R.id.location_icon)
        private val shippingInfo: TextView = itemView.findViewById(R.id.shipping_info)
        private val quantity: TextView = itemView.findViewById(R.id.quantity)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(shippedProduct: ShippedProductsByLocation) {
            shippingInfo.text = "${shippedProduct.shippingCity}, ${shippedProduct.shippingCountry}" // Asigna la ciudad y país
            quantity.text = "Cantidad de envíos: $${shippedProduct.quantity}" // Asigna la cantidad de envíos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShippedProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shipped_location, parent, false)
        return ShippedProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shippedProducts.size
    }

    override fun onBindViewHolder(holder: ShippedProductViewHolder, position: Int) {
        val shippedProduct = shippedProducts[position]
        holder.bind(shippedProduct)
    }
}
