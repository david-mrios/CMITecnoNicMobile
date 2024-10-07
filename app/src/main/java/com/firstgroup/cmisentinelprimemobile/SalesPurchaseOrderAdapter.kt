package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SalesPurchaseOrderAdapter(orderList: List<SalesByPurchaseOrder>) :
    RecyclerView.Adapter<SalesPurchaseOrderAdapter.OrderViewHolder>() {

    // Filtrar los pedidos para excluir los que tienen estado "enviado"
    private val filteredOrderList: List<SalesByPurchaseOrder> =
        orderList.filter { it.orderStatus != "enviado" }

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSalesStatus: TextView = itemView.findViewById(R.id.tvSalesStatus)
        private val tvSalesAmount: TextView = itemView.findViewById(R.id.tvSalesAmount)
        private val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        private val statusIcon: ImageView = itemView.findViewById(R.id.imgSalesStatus)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(order: SalesByPurchaseOrder) {
            // Verificar si el estado es "en proceso" y cambiar a "en ruta"
            val statusText = if (order.orderStatus == "en proceso") {
                "Estado: en ruta" // Cambia "en proceso" por "en ruta"
            } else {
                "Estado: ${order.orderStatus}" // Asigna el estado original
            }

            tvSalesStatus.text = statusText // Asigna el estado de la venta
            tvSalesAmount.text = "Monto de ventas: $${order.salesAmount}" // Asigna el monto de la venta
            tvQuantity.text = "Cantidad: ${order.quantity}" // Asigna la cantidad

            when (order.orderStatus) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sales_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredOrderList.size // Cambiado para devolver el tamaño de la lista filtrada
    }

    // Vincula los datos al ViewHolder
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = filteredOrderList[position] // Usar la lista filtrada
        holder.bind(order)
    }
}
