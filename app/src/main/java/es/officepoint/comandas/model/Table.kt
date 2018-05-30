package es.officepoint.comandas.model

import java.util.*

data class Table (var name: String,
                  var order: MutableList<Dish>){

    val id : String = UUID.randomUUID().toString()
}
