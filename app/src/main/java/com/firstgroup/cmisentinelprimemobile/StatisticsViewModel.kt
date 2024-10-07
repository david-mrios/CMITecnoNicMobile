package com.firstgroup.cmisentinelprimemobile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
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

    private val gson = Gson()

    fun loadSalesByCustomerAndProduct() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-customer-and-product")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val salesList = gson.fromJson(jsonString, Array<SalesByCustomerAndProduct>::class.java).toList().take(10)
                salesByCustomerAndProduct.postValue(salesList)
            }
    }

    fun loadSalesByShipmentLocation() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-shipment-location")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val salesList = gson.fromJson(jsonString, Array<SalesByShipmentLocation>::class.java).toList().take(10)
                salesByShipmentLocation.postValue(salesList)
            }
    }

    fun loadShippingCostByProduct() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipping-cost-by-product")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val costList = gson.fromJson(jsonString, Array<ShippingCostByProduct>::class.java).toList().take(10)
                shippingCostByProduct.postValue(costList)
            }
    }

    fun loadSalesByPurchaseOrder() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-purchase-order")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val salesList = gson.fromJson(jsonString, Array<SalesByPurchaseOrder>::class.java).toList().take(10)
                salesByPurchaseOrder.postValue(salesList)
            }
    }

    fun loadTaxesByCustomer() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-taxes-by-customer")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val taxesList = gson.fromJson(jsonString, Array<TaxesByCustomer>::class.java).toList().take(10)
                taxesByCustomer.postValue(taxesList)
            }
    }

    fun loadShippedProductsByLocation() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipped-products-by-location")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val productsList = gson.fromJson(jsonString, Array<ShippedProductsByLocation>::class.java).toList().take(10)
                shippedProductsByLocation.postValue(productsList)
            }
    }

    fun loadShippingCostByPurchaseOrder() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-shipping-cost-by-purchase-order")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val costList = gson.fromJson(jsonString, Array<ShippingCostByPurchaseOrder>::class.java).toList().take(10)
                shippingCostByPurchaseOrder.postValue(costList)
            }
    }

    fun loadSalesByShipmentLocationPivot() {
        Fuel.get("https://4slz48p3-5069.use2.devtunnels.ms/cubedata/get-sales-by-shipment-location-pivot")
            .response { _, response, _ ->
                val jsonString = response.body().asString("application/json; charset=utf-8")
                val salesList = gson.fromJson(jsonString, Array<SalesByShipmentLocationPivot>::class.java).toList().take(10)
                salesByShipmentLocationPivot.postValue(salesList)
            }
    }
}
