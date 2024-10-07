package com.firstgroup.cmisentinelprimemobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firstgroup.cmisentinelprimemobile.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {
    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[StatisticsViewModel::class.java]

        setupRecyclerViews()

        observeData()

        loadData()

        return binding.root
    }

    private fun setupRecyclerViews() {
        binding.rvSalesByCustomerAndProduct.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSalesByShipmentLocation.layoutManager = LinearLayoutManager(requireContext())
        binding.rvShippingCostByProduct.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSalesByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTaxesByCustomer.layoutManager = LinearLayoutManager(requireContext())
        binding.rvShippedProductsByLocation.layoutManager = LinearLayoutManager(requireContext())
        binding.rvShippingCostByPurchaseOrder.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSalesByShipmentLocationPivot.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeData() {
        viewModel.salesByCustomerAndProduct.observe(viewLifecycleOwner) { salesList ->
            binding.pbSalesByCustomerAndProduct.visibility = View.GONE // Ocultar ProgressBar
            if (salesList.isNotEmpty()) {
                binding.rvSalesByCustomerAndProduct.adapter = SalesCustomerProductAdapter(salesList)
            }
        }

        viewModel.salesByShipmentLocation.observe(viewLifecycleOwner) { salesList ->
            binding.pbSalesByShipmentLocation.visibility = View.GONE // Ocultar ProgressBar
            if (salesList.isNotEmpty()) {
                binding.rvSalesByShipmentLocation.adapter = SalesShipmentLocationAdapter(salesList)
            }
        }

        viewModel.shippingCostByProduct.observe(viewLifecycleOwner) { costList ->
            binding.pbShippingCostByProduct.visibility = View.GONE // Ocultar ProgressBar
            if (costList.isNotEmpty()) {
                binding.rvShippingCostByProduct.adapter = ShippingCostProductAdapter(costList)
            }
        }

        viewModel.salesByPurchaseOrder.observe(viewLifecycleOwner) { salesList ->
            binding.pbSalesByPurchaseOrder.visibility = View.GONE // Ocultar ProgressBar
            if (salesList.isNotEmpty()) {
                binding.rvSalesByPurchaseOrder.adapter = SalesPurchaseOrderAdapter(salesList)
            }
        }

        viewModel.taxesByCustomer.observe(viewLifecycleOwner) { taxesList ->
            binding.pbTaxesByCustomer.visibility = View.GONE // Ocultar ProgressBar
            if (taxesList.isNotEmpty()) {
                binding.rvTaxesByCustomer.adapter = TaxesCustomerAdapter(taxesList)
            }
        }

        viewModel.shippedProductsByLocation.observe(viewLifecycleOwner) { productsList ->
            binding.pbShippedProductsByLocation.visibility = View.GONE // Ocultar ProgressBar
            if (productsList.isNotEmpty()) {
                binding.rvShippedProductsByLocation.adapter = ShippedProductsByLocationAdapter(productsList)
            }
        }

        viewModel.shippingCostByPurchaseOrder.observe(viewLifecycleOwner) { costList ->
            binding.pbShippingCostByPurchaseOrder.visibility = View.GONE // Ocultar ProgressBar
            if (costList.isNotEmpty()) {
                binding.rvShippingCostByPurchaseOrder.adapter = ShippingCostByPurchaseOrderAdapter(costList)
            }
        }

        viewModel.salesByShipmentLocationPivot.observe(viewLifecycleOwner) { salesList ->
            binding.pbSalesByShipmentLocationPivot.visibility = View.GONE // Ocultar ProgressBar
            if (salesList.isNotEmpty()) {
                binding.rvSalesByShipmentLocationPivot.adapter = SalesShipmentPivotAdapter(salesList)
            }
        }

        // Observa el error y muestra un Toast si ocurre
        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
                // Puedes realizar acciones adicionales aquí si es necesario, como mantener visible el ProgressBar
            }
        }
    }

    private fun loadData() {
        if (viewModel.salesByCustomerAndProduct.value == null) {
            binding.pbSalesByCustomerAndProduct.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadSalesByCustomerAndProduct()
        }

        if (viewModel.salesByShipmentLocation.value == null) {
            binding.pbSalesByShipmentLocation.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadSalesByShipmentLocation()
        }

        if (viewModel.shippingCostByProduct.value == null) {
            binding.pbShippingCostByProduct.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadShippingCostByProduct()
        }

        if (viewModel.salesByPurchaseOrder.value == null) {
            binding.pbSalesByPurchaseOrder.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadSalesByPurchaseOrder()
        }

        if (viewModel.taxesByCustomer.value == null) {
            binding.pbTaxesByCustomer.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadTaxesByCustomer()
        }

        if (viewModel.shippedProductsByLocation.value == null) {
            binding.pbShippedProductsByLocation.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadShippedProductsByLocation()
        }

        if (viewModel.shippingCostByPurchaseOrder.value == null) {
            binding.pbShippingCostByPurchaseOrder.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadShippingCostByPurchaseOrder()
        }

        if (viewModel.salesByShipmentLocationPivot.value == null) {
            binding.pbSalesByShipmentLocationPivot.visibility = View.VISIBLE // Mostrar ProgressBar
            viewModel.loadSalesByShipmentLocationPivot()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
