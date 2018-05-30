package es.officepoint.comandas.model

import java.util.*

enum class TemperatureUnit {
    CELSIUS,
    FAHRENHEIT
}


data class Dish (val name: String,
                 val price: Float,
                 val variants: String){

    val id : String = UUID.randomUUID().toString()
}