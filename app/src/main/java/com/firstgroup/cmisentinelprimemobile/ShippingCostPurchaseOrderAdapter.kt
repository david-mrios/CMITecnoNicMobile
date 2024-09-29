package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShippingCostByPurchaseOrderAdapter(private val purchaseOrders: List<ShippingCostByPurchaseOrder>) :
    RecyclerView.Adapter<ShippingCostByPurchaseOrderAdapter.PurchaseOrderViewHolder>() {

    class PurchaseOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val statusIcon: ImageView = itemView.findViewById(R.id.status_icon)
        private val statusText: TextView = itemView.findViewById(R.id.status_text)
        private val shippingCost: TextView = itemView.findViewById(R.id.shipping_cost)

        @SuppressLint("SetTextI18n")
        fun bind(purchaseOrder: ShippingCostByPurchaseOrder) {
            statusText.text = "Estado: ${purchaseOrder.orderStatus}" // Asigna el estado de la orden
            shippingCost.text = "Costo de Envío: $${purchaseOrder.shippingCost}" // Asigna el costo de envío
            when (purchaseOrder.orderStatus) {
                "cancelado" -> {
                    statusIcon.setImageResource(R.drawable.ic_cancelled)
                }
                "entregado" -> {
                    statusIcon.setImageResource(R.drawable.ic_delivered) // Icono de ejemplo para otros estados
                }
                "enviado" -> {
                    statusIcon.setImageResource(R.drawable.ic_delivered) // Icono de ejemplo para otros estados
                }
                "pendiente" -> {
                    statusIcon.setImageResource(R.drawable.ic_pending) // Icono de ejemplo para otros estados
                }
                else -> {
                    statusIcon.setImageResource(R.drawable.ic_pending) // Icono de ejemplo para otros estados
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseOrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shipping_cost_order, parent, false)
        return PurchaseOrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return purchaseOrders.size
    }

    override fun onBindViewHolder(holder: PurchaseOrderViewHolder, position: Int) {
        val purchaseOrder = purchaseOrders[position]
        holder.bind(purchaseOrder)
    }
}
