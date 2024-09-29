package com.firstgroup.cmisentinelprimemobile

import com.google.gson.annotations.SerializedName

// 1. Total de ventas por cliente y producto (Operación: Dice)
data class SalesByCustomerAndProduct(
    @SerializedName("Customer Key") val customerKey: String,  // Clave del cliente
    @SerializedName("ProductHierarchy") val product: String,          // Nombre del producto
    @SerializedName("Sales Amount") val salesAmount: Double, // Monto total de ventas
    @SerializedName("Quantity") val quantity: Int            // Cantidad vendida
)

// 2. Monto total de ventas por ubicación de envío (Operación: Slice)
data class SalesByShipmentLocation(
    @SerializedName("Shipping City") val shippingCity: String,     // Ciudad de envío
    @SerializedName("Shipping Country") val shippingCountry: String, // País de envío
    @SerializedName("Sales Amount") val salesAmount: Double        // Monto total de ventas
)


// 3. Costo total de envío por cada producto (Operación: Slice)
data class ShippingCostByProduct(
    @SerializedName("ProductHierarchy") val product: String,          // Producto
    @SerializedName("Brand Name") val brandName: String,     // Marca
    @SerializedName("Shipping Cost") val shippingCost: Double // Costo de envío por producto
)

// 4. Total de ventas por orden de compra (Operación: Dice)
data class SalesByPurchaseOrder(
    @SerializedName("Status") val orderStatus: String,  // Estado de la orden
    @SerializedName("Sales Amount") val salesAmount: Double,  // Monto total de ventas
    @SerializedName("Quantity") val quantity: Int             // Cantidad de productos en la orden
)

// 5. Impuestos por cada cliente (Operación: Dice)
data class TaxesByCustomer(
    @SerializedName("Customer Key") val customerKey: String,  // Clave del cliente
    @SerializedName("Last Name") val lastName: String,        // Apellido del cliente
    @SerializedName("Tax Amount") val taxAmount: Double       // Monto total de impuestos
)

// 6. Cantidad de productos enviados por cada ubicación de envío (Operación: Dice)
data class ShippedProductsByLocation(
    @SerializedName("Shipping City") val shippingCity: String,     // Ciudad de envío
    @SerializedName("Shipping Country") val shippingCountry: String, // País de envío
    @SerializedName("Quantity") val quantity: Int                  // Cantidad de productos enviados
)

// 7. Costo total de envío por cada orden de compra (Operación: Slice)
data class ShippingCostByPurchaseOrder(
    @SerializedName("Status") val orderStatus: String,   // Estado de la orden
    @SerializedName("Shipping Cost") val shippingCost: Double  // Costo total de envío
)

// 8. Monto total de ventas en función de la ubicación de envío (Operación: Pivot)
data class SalesByShipmentLocationPivot(
    @SerializedName("Shipping Address") val shippingAddress: String,  // Dirección de envío
    @SerializedName("Shipping City") val shippingCity: String,        // Ciudad de envío
    @SerializedName("Shipping Country") val shippingCountry: String,  // País de envío
    @SerializedName("Shipping Cost") val shippingCost: Double         // Costo de envío
)

// Declaración una lista
lateinit var salesByCustomerAndProductList: List<SalesByCustomerAndProduct>
lateinit var salesByShipmentLocationList: List<SalesByShipmentLocation>
lateinit var ShippingCostByProductList: List<ShippingCostByProduct>
lateinit var salesByPurchaseOrderList: List<SalesByPurchaseOrder>
lateinit var taxesByCustomerList: List<TaxesByCustomer>
lateinit var shippedProductsByLocationList: List<ShippedProductsByLocation>
lateinit var shippingCostByPurchaseOrderList: List<ShippingCostByPurchaseOrder>
lateinit var salesByShipmentLocationPivotList: List<SalesByShipmentLocationPivot>
