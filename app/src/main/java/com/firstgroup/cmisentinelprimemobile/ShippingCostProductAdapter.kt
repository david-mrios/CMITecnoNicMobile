package com.firstgroup.cmisentinelprimemobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ShippingCostProductAdapter(private val productList: List<ShippingCostByProduct>):
    RecyclerView.Adapter<ShippingCostProductAdapter.ProductViewHolder>() {

    // ViewHolder: Vincula los elementos del layout con los datos
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvProductHierarchy = itemView.findViewById<TextView>(R.id.tvProductHierarchy)
        private val tvBrandName = itemView.findViewById<TextView>(R.id.tvBrandName)
        private val tvShippingCost = itemView.findViewById<TextView>(R.id.tvShippingCost)

        // Función para asignar los datos a los elementos de la vista
        @SuppressLint("SetTextI18n")
        fun bind(product: ShippingCostByProduct) {
            tvProductHierarchy.text = "Product: ${product.product}" // Asigna la jerarquía del producto
            tvBrandName.text = "Brand: ${product.brandName}" // Asigna el nombre de la marca
            tvShippingCost.text = "Shipping Cost: ${product.shippingCost}" // Asigna el costo de envío
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shipping_cost_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }
}
