package es.officepoint.comandas.model

import java.util.*

data class Table (var name: String,
                  var orders: MutableList<Order>){

    val id : String = UUID.randomUUID().toString()
}
