package es.officepoint.comandas

import java.util.*

fun Float.toString(currency: String) =  "%.2f".format(this) + " " + currency
