package com.firstgroup.cmisentinelprimemobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstgroup.cmisentinelprimemobile.databinding.FragmentStatisticsBinding
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StatisticsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    // RecyclerView declarations
    private lateinit var rvSalesByCustomerAndProduct: RecyclerView
    private lateinit var rvSalesByShipmentLocation: RecyclerView
    private lateinit var rvShippingCostByProduct: RecyclerView
    private lateinit var rvSalesByPurchaseOrder: RecyclerView
    private lateinit var rvTaxesByCustomer: RecyclerView
    private lateinit var rvShippedProductsByLocation: RecyclerView
    private lateinit var rvShippingCostByPurchaseOrder: RecyclerView
    private lateinit var rvSalesByShipmentLocationPivot: RecyclerView

    // Progress bar declarations
    private lateinit var pbSalesByCustomerAndProduct: View
    private lateinit var pbSalesByShipmentLocation: View
    private lateinit var pbShippingCostByProduct: View
    private lateinit var pbSalesByPurchaseOrder: View
    private lateinit var pbTaxesByCustomer: View
    private lateinit var pbShippedProductsByLocation: View
    private lateinit var pbShippingCostByPurchaseOrder: View
    private lateinit var pbSalesByShipmentLocationPivot: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)

        // Initialize RecyclerViews
        rvSalesByCustomerAndProduct = binding.rvSalesByCustomerAndProduct
        rvSalesByShipmentLocation = binding.rvSalesByShipmentLocation
        rvShippingCostByProduct = binding.rvShippingCostByProduct
        rvSalesByPurchaseOrder = binding.rvSalesByPurchaseOrder
        rvTaxesByCustomer = binding.rvTaxesByCustomer
        rvShippedProductsByLocation = binding.rvShippedProductsByLocation
        rvShippingCostByPurchaseOrder = binding.rvShippingCostByPurchaseOrder
        rvSalesByShipmentLocationPivot = binding.rvSalesByShipmentLocationPivot

        // Initialize progress bars
        pbSalesByCustomerAndProduct = binding.pbSalesByCustomerAndProduct
        pbSalesByShipmentLocation = binding.pbSalesByShipmentLocation
        pbShippingCostByProduct = binding.pbShippingCostByProduct
        pbSalesByPurchaseOrder = binding.pbSalesByPurchaseOrder
        pbTaxesByCustomer = binding.pbTaxesByCustomer
        pbShippedProductsByLocation = binding.pbShippedProductsByLocation
        pbShippingCostByPurchaseOrder = binding.pbShippingCostByPurchaseOrder
        pbSalesByShipmentLocationPivot = binding.pbSalesByShipmentLocationPivot

        // Load data and manage progress bars
        loadSalesByCustomerAndProduct()
        loadSalesByShipmentLocation()
        loadShippingCostByProduct()
        loadSalesByPurchaseOrder()
        loadTaxesByCustomer()
        loadShippedProductsByLocation()
        loadShippingCostByPurchaseOrder()
        loadSalesByShipmentLocationPivot()

        return binding.root
    }

    private fun loadSalesByCustomerAndProduct() {
        pbSalesByCustomerAndProduct.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-customer-and-product")
            .response { _, response, _ ->
                pbSalesByCustomerAndProduct.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val salesByCustomerAndProductList =
                    gson.fromJson(jsonString, Array<SalesByCustomerAndProduct>::class.java).toList().take(10)
                rvSalesByCustomerAndProduct.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByCustomerAndProduct.adapter = SalesCustomerProductAdapter(salesByCustomerAndProductList)
            }
    }

    private fun loadSalesByShipmentLocation() {
        pbSalesByShipmentLocation.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-shipment-location")
            .response { _, response, _ ->
                pbSalesByShipmentLocation.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val salesByShipmentLocationList =
                    gson.fromJson(jsonString, Array<SalesByShipmentLocation>::class.java).toList().take(10)
                rvSalesByShipmentLocation.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByShipmentLocation.adapter = SalesShipmentLocationAdapter(salesByShipmentLocationList)
            }
    }

    private fun loadShippingCostByProduct() {
        pbShippingCostByProduct.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipping-cost-by-product")
            .response { _, response, _ ->
                pbShippingCostByProduct.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val shippingCostByProductList =
                    gson.fromJson(jsonString, Array<ShippingCostByProduct>::class.java).toList().take(10)
                rvShippingCostByProduct.layoutManager = LinearLayoutManager(requireContext())
                rvShippingCostByProduct.adapter = ShippingCostProductAdapter(shippingCostByProductList)
            }
    }

    private fun loadSalesByPurchaseOrder() {
        pbSalesByPurchaseOrder.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-purchase-order")
            .response { _, response, _ ->
                pbSalesByPurchaseOrder.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val salesByPurchaseOrderList =
                    gson.fromJson(jsonString, Array<SalesByPurchaseOrder>::class.java).toList().take(10)
                rvSalesByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByPurchaseOrder.adapter = SalesPurchaseOrderAdapter(salesByPurchaseOrderList)
            }
    }

    private fun loadTaxesByCustomer() {
        pbTaxesByCustomer.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-taxes-by-customer")
            .response { _, response, _ ->
                pbTaxesByCustomer.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val taxesByCustomerList = gson.fromJson(jsonString, Array<TaxesByCustomer>::class.java).toList().take(10)
                rvTaxesByCustomer.layoutManager = LinearLayoutManager(requireContext())
                rvTaxesByCustomer.adapter = TaxesCustomerAdapter(taxesByCustomerList)
            }
    }

    private fun loadShippedProductsByLocation() {
        pbShippedProductsByLocation.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipped-products-by-location")
            .response { _, response, _ ->
                pbShippedProductsByLocation.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val shippedProductsByLocationList = gson.fromJson(jsonString, Array<ShippedProductsByLocation>::class.java).toList().take(10)
                rvShippedProductsByLocation.layoutManager = LinearLayoutManager(requireContext())
                rvShippedProductsByLocation.adapter = ShippedProductsByLocationAdapter(shippedProductsByLocationList)
            }
    }

    private fun loadShippingCostByPurchaseOrder() {
        pbShippingCostByPurchaseOrder.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipping-cost-by-purchase-order")
            .response { _, response, _ ->
                pbShippingCostByPurchaseOrder.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val shippingCostByPurchaseOrderList = gson.fromJson(jsonString, Array<ShippingCostByPurchaseOrder>::class.java).toList().take(10)
                rvShippingCostByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
                rvShippingCostByPurchaseOrder.adapter = ShippingCostByPurchaseOrderAdapter(shippingCostByPurchaseOrderList)
            }
    }

    private fun loadSalesByShipmentLocationPivot() {
        pbSalesByShipmentLocationPivot.visibility = View.VISIBLE // Show progress bar
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-shipment-location-pivot")
            .response { _, response, _ ->
                pbSalesByShipmentLocationPivot.visibility = View.GONE // Hide progress bar
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val gson = Gson()
                val salesByShipmentLocationPivotList = gson.fromJson(jsonString, Array<SalesByShipmentLocationPivot>::class.java).toList().take(10)
                rvSalesByShipmentLocationPivot.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByShipmentLocationPivot.adapter = SalesShipmentPivotAdapter(salesByShipmentLocationPivotList)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatisticsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
