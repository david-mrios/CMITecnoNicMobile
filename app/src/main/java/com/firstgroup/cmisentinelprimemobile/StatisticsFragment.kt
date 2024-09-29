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

        // 1. SalesByCustomerAndProduct
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                salesByCustomerAndProductList =
                    gson.fromJson(jsonString, Array<SalesByCustomerAndProduct>::class.java).toList()
                rvSalesByCustomerAndProduct.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByCustomerAndProduct.adapter =
                    SalesCustomerProductAdapter(salesByCustomerAndProductList)
            }

        // 2. SalesByShipmentLocation
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                salesByShipmentLocationList =
                    gson.fromJson(jsonString, Array<SalesByShipmentLocation>::class.java).toList()
                rvSalesByShipmentLocation.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByShipmentLocation.adapter = SalesShipmentLocationAdapter(salesByShipmentLocationList)
            }

        // 3. ShippingCostByProduct
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                ShippingCostByProductList =
                    gson.fromJson(jsonString, Array<ShippingCostByProduct>::class.java).toList()
                rvShippingCostByProduct.layoutManager = LinearLayoutManager(requireContext())
                rvShippingCostByProduct.adapter =
                    ShippingCostProductAdapter(ShippingCostByProductList)
            }

        // 4. SalesByPurchaseOrder
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                salesByPurchaseOrderList =
                    gson.fromJson(jsonString, Array<SalesByPurchaseOrder>::class.java).toList()
                rvSalesByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByPurchaseOrder.adapter = SalesPurchaseOrderAdapter(salesByPurchaseOrderList)
            }

        // 5. TaxesByCustomer
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                taxesByCustomerList = gson.fromJson(jsonString, Array<TaxesByCustomer>::class.java).toList()
                rvTaxesByCustomer.layoutManager = LinearLayoutManager(requireContext())
                rvTaxesByCustomer.adapter = TaxesCustomerAdapter(taxesByCustomerList)
            }

        // 6. ShippedProductsByLocation
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                shippedProductsByLocationList = gson.fromJson(jsonString, Array<ShippedProductsByLocation>::class.java).toList()
                rvShippedProductsByLocation.layoutManager = LinearLayoutManager(requireContext())
                rvShippedProductsByLocation.adapter = ShippedProductsByLocationAdapter(shippedProductsByLocationList)
            }

        // 7. ShippingCostByPurchaseOrder
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                shippingCostByPurchaseOrderList = gson.fromJson(jsonString, Array<ShippingCostByPurchaseOrder>::class.java).toList()
                rvShippingCostByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
                rvShippingCostByPurchaseOrder.adapter = ShippingCostByPurchaseOrderAdapter(shippingCostByPurchaseOrderList)
            }

        // 8.  SalesByShipmentLocationPivot
        Fuel.get("")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json")
                val gson = Gson()
                salesByShipmentLocationPivotList = gson.fromJson(jsonString, Array<SalesByShipmentLocationPivot>::class.java).toList()
                rvSalesByShipmentLocationPivot.layoutManager = LinearLayoutManager(requireContext())
                rvSalesByShipmentLocationPivot.adapter = SalesShipmentPivotAdapter(salesByShipmentLocationPivotList)
            }
        return binding.root
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
