package es.officepoint.comandas.model


import android.content.Context
import es.officepoint.comandas.R
import java.util.*

data class Table (var name: String,
                  var orders: MutableList<Order>){

    val id : String = UUID.randomUUID().toString()

    fun getOrderIndex(order: Order): Int{
        return orders.indexOf(order)
    }

    fun getTotalPrice() : Float {
        return orders.map { it.dish.price }.sum()
    }

}
