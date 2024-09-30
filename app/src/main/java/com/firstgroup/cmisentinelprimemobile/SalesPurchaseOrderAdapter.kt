package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SalesPurchaseOrderAdapter(private val orderList: List<SalesByPurchaseOrder>) :
    RecyclerView.Adapter<SalesPurchaseOrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSalesStatus = itemView.findViewById<TextView>(R.id.tvSalesStatus)
        private val tvSalesAmount = itemView.findViewById<TextView>(R.id.tvSalesAmount)
        private val tvQuantity = itemView.findViewById<TextView>(R.id.tvQuantity)
        private val statusIcon: ImageView = itemView.findViewById(R.id.imgSalesStatus)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(order: SalesByPurchaseOrder) {
            tvSalesStatus.text = "Estado: ${order.orderStatus}" // Asigna el estado de la venta
            tvSalesAmount.text = "Monto de ventas: $${order.salesAmount}" // Asigna el monto de la venta
            tvQuantity.text = "Cantidad: ${order.quantity}" // Asigna la cantidad

            when (order.orderStatus) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sales_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    // Vincula los datos al ViewHolder
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderList[position]
        holder.bind(order)
    }
}
