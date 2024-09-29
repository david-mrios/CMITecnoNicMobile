package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SalesCustomerProductAdapter(private val salesList: List<SalesByCustomerAndProduct>):
    RecyclerView.Adapter<SalesCustomerProductAdapter.SalesViewHolder>() {

    class SalesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvCustomerName = itemView.findViewById<TextView>(R.id.tvCustomerName)
        private val tvProductHierarchy = itemView.findViewById<TextView>(R.id.tvProductHierarchy)
        private val tvSalesAmount = itemView.findViewById<TextView>(R.id.tvSalesAmount)
        private val tvQuantity = itemView.findViewById<TextView>(R.id.tvQuantity)

        @SuppressLint("SetTextI18n")
        fun bind(sale: SalesByCustomerAndProduct) {
            tvCustomerName.text = "Customer Name: ${sale.customerKey}"
            tvProductHierarchy.text = "Product: ${sale.product}"
            tvSalesAmount.text = "Sales: ${sale.salesAmount}"
            tvQuantity.text = "Qty : ${sale.quantity}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sales_customer, parent, false)
        return SalesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return salesList.size
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        val sale = salesList[position]
        holder.bind(sale)
    }
}
