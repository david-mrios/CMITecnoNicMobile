package com.firstgroup.cmisentinelprimemobile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.result.Result
import com.google.gson.Gson

class StatisticsViewModel : ViewModel() {
    val salesByCustomerAndProduct = MutableLiveData<List<SalesByCustomerAndProduct>>()
    val salesByShipmentLocation = MutableLiveData<List<SalesByShipmentLocation>>()
    val shippingCostByProduct = MutableLiveData<List<ShippingCostByProduct>>()
    val salesByPurchaseOrder = MutableLiveData<List<SalesByPurchaseOrder>>()
    val taxesByCustomer = MutableLiveData<List<TaxesByCustomer>>()
    val shippedProductsByLocation = MutableLiveData<List<ShippedProductsByLocation>>()
    val shippingCostByPurchaseOrder = MutableLiveData<List<ShippingCostByPurchaseOrder>>()
    val salesByShipmentLocationPivot = MutableLiveData<List<SalesByShipmentLocationPivot>>()

    val errorMessage = MutableLiveData<String>() // Para manejar errores

    private val gson = Gson()

    private fun <T> handleResponse(
        result: Result<ByteArray, FuelError>,
        liveData: MutableLiveData<List<T>>,
        type: Class<Array<T>>
    ) {
        try {
            when (result) {
                is Result.Success -> {
                    val jsonString = result.get().toString(Charsets.UTF_8)
                    val dataList = gson.fromJson(jsonString, type).toList().take(10)
                    liveData.postValue(dataList)
                }
                is Result.Failure -> {
                    errorMessage.postValue("Error: ${result.error.message}")
                }
            }
        } catch (e: Exception) {
            errorMessage.postValue("Exception: ${e.message}")
        }
    }

    fun loadSalesByCustomerAndProduct() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-sales-by-customer-and-product")
            .response { _, _, result ->
                handleResponse(result, salesByCustomerAndProduct, Array<SalesByCustomerAndProduct>::class.java)
            }
    }

    fun loadSalesByShipmentLocation() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-sales-by-shipment-location")
            .response { _, _, result ->
                handleResponse(result, salesByShipmentLocation, Array<SalesByShipmentLocation>::class.java)
            }
    }

    fun loadShippingCostByProduct() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-shipping-cost-by-product")
            .response { _, _, result ->
                handleResponse(result, shippingCostByProduct, Array<ShippingCostByProduct>::class.java)
            }
    }

    fun loadSalesByPurchaseOrder() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-sales-by-purchase-order")
            .response { _, _, result ->
                handleResponse(result, salesByPurchaseOrder, Array<SalesByPurchaseOrder>::class.java)
            }
    }

    fun loadTaxesByCustomer() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-taxes-by-customer")
            .response { _, _, result ->
                handleResponse(result, taxesByCustomer, Array<TaxesByCustomer>::class.java)
            }
    }

    fun loadShippedProductsByLocation() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-shipped-products-by-location")
            .response { _, _, result ->
                handleResponse(result, shippedProductsByLocation, Array<ShippedProductsByLocation>::class.java)
            }
    }

    fun loadShippingCostByPurchaseOrder() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-shipping-cost-by-purchase-order")
            .response { _, _, result ->
                handleResponse(result, shippingCostByPurchaseOrder, Array<ShippingCostByPurchaseOrder>::class.java)
            }
    }

    fun loadSalesByShipmentLocationPivot() {
        Fuel.get("https://serverfirstgroup.westus2.cloudapp.azure.com/apiolap/cubedata/get-sales-by-shipment-location-pivot")
            .response { _, _, result ->
                handleResponse(result, salesByShipmentLocationPivot, Array<SalesByShipmentLocationPivot>::class.java)
            }
    }
}
