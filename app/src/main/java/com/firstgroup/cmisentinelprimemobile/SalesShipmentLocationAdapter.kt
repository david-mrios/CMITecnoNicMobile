package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class SalesShipmentLocationAdapter(private val shipmentList: List<SalesByShipmentLocation>):
    RecyclerView.Adapter<SalesShipmentLocationAdapter.ShipmentViewHolder>() {

    class ShipmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvShippingCity = itemView.findViewById<TextView>(R.id.tvShippingCity)
        private val tvShippingCountry = itemView.findViewById<TextView>(R.id.tvShippingCountry)
        private val tvSalesAmount = itemView.findViewById<TextView>(R.id.tvSalesAmount)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(shipment: SalesByShipmentLocation) {
            tvShippingCity.text = "City: ${shipment.shippingCity}" // Asigna la ciudad
            tvShippingCountry.text = "Country: ${shipment.shippingCountry}" // Asigna el país
            tvSalesAmount.text = "Sales: ${shipment.salesAmount}" // Asigna el monto de ventas
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sales_location, parent, false)
        return ShipmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shipmentList.size
    }

    override fun onBindViewHolder(holder: ShipmentViewHolder, position: Int) {
        val shipment = shipmentList[position]
        holder.bind(shipment)
    }
}
