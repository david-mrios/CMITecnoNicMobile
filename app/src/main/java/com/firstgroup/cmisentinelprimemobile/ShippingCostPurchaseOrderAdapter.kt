package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShippingCostByPurchaseOrderAdapter(purchaseOrders: List<ShippingCostByPurchaseOrder>) :
    RecyclerView.Adapter<ShippingCostByPurchaseOrderAdapter.PurchaseOrderViewHolder>() {

    // Filtrar los pedidos para excluir los que ienen estado "enviado"
    private val filteredPurchaseOrders: List<ShippingCostByPurchaseOrder> =
        purchaseOrders.filter { it.orderStatus != "enviado" }

    class PurchaseOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val statusIcon: ImageView = itemView.findViewById(R.id.status_icon)
        private val statusText: TextView = itemView.findViewById(R.id.status_text)
        private val shippingCost: TextView = itemView.findViewById(R.id.shipping_cost)

        @SuppressLint("SetTextI18n")
        fun bind(purchaseOrder: ShippingCostByPurchaseOrder) {
            val statusDisplayText = if (purchaseOrder.orderStatus == "en proceso") {
                "Estado: En ruta"
            } else {
                "Estado: ${purchaseOrder.orderStatus}"
            }

            statusText.text = statusDisplayText // Asigna el estado de la orden
            shippingCost.text = "Costo de Envío: $${purchaseOrder.shippingCost}" // Asigna el costo de envío

            when (purchaseOrder.orderStatus) {
                "cancelado" -> {
                    statusIcon.setImageResource(R.drawable.ic_cancelled)
                }
                "entregado" -> {
                    statusIcon.setImageResource(R.drawable.ic_delivered) // Icono de entregado
                }
                "pendiente" -> {
                    statusIcon.setImageResource(R.drawable.ic_pending) // Icono de pendiente
                }
                else -> {
                    statusIcon.setImageResource(R.drawable.ic_in_route) // Icono por defecto
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
        return filteredPurchaseOrders.size // Cambiado para devolver el tamaño de la lista filtrada
    }

    override fun onBindViewHolder(holder: PurchaseOrderViewHolder, position: Int) {
        val purchaseOrder = filteredPurchaseOrders[position] // Usar la lista filtrada
        holder.bind(purchaseOrder)
    }
}
