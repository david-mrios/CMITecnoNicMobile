package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaxesCustomerAdapter(private val taxList: List<TaxesByCustomer>) :
    RecyclerView.Adapter<TaxesCustomerAdapter.TaxesViewHolder>() {

    class TaxesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCustomerKey = itemView.findViewById<TextView>(R.id.tvCustomerKey)
        private val tvTaxAmount = itemView.findViewById<TextView>(R.id.tvTaxAmount)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(taxesCustomer: TaxesByCustomer) {
            tvCustomerKey.text = "Cliente: ${taxesCustomer.customerKey} ${taxesCustomer.lastName}" // Asigna la clave del cliente
            tvTaxAmount.text = "Impuestos totales: $${taxesCustomer.taxAmount}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaxesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_taxes_customer, parent, false)
        return TaxesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taxList.size
    }

    override fun onBindViewHolder(holder: TaxesViewHolder, position: Int) {
        val taxesCustomer = taxList[position]
        holder.bind(taxesCustomer)
    }
}
