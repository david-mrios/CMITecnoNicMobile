package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SalesShipmentPivotAdapter(private val salesShipments: List<SalesByShipmentLocationPivot>) :
    RecyclerView.Adapter<SalesShipmentPivotAdapter.SalesShipmentViewHolder>() {

    class SalesShipmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shippingAddress: TextView = itemView.findViewById(R.id.shipping_address)
        private val shippingCity: TextView = itemView.findViewById(R.id.shipping_city)
        private val shippingCountry: TextView = itemView.findViewById(R.id.shipping_country)
        private val shippingCost: TextView = itemView.findViewById(R.id.shipping_cost)

        @SuppressLint("SetTextI18n")
        fun bind(salesShipment: SalesByShipmentLocationPivot) {
            shippingAddress.text = "Dirección: ${salesShipment.shippingAddress}"  // Dirección de envío
            shippingCity.text = "Ciudad: ${salesShipment.shippingCity}"            // Ciudad
            shippingCountry.text = "País: ${salesShipment.shippingCountry}"       // País
            shippingCost.text = "Costo de Envío: $${salesShipment.shippingCost}" // Costo de envío
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesShipmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sales_location_pivot, parent, false) // Usa tu layout XML
        return SalesShipmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return salesShipments.size
    }

    override fun onBindViewHolder(holder: SalesShipmentViewHolder, position: Int) {
        val salesShipment = salesShipments[position]
        holder.bind(salesShipment)
    }
}
