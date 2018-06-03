package es.officepoint.comandas.model

import es.officepoint.comandas.R
import es.officepoint.comandas.toString
import java.util.*

enum class AllergenEnum {
    GLUTEN,
    CRUSTACEOS,
    HUEVO,
    PESCADO,
    CACAHUETE,
    SOJA,
    LACTEOS,
    FRUTOS_SECOS,
    APIO,
    MOSTAZA,
    SESAMO,
    SULFITOS,
    ALTRAMUCES,
    MOLUSCOS
}


data class Dish (val name: String,
                 val price: Float,
                 val icon: Int,
                 val allergen: List<AllergenEnum> = listOf()
                ){

    val id : String = UUID.randomUUID().toString()

    fun getPriceString(currency : String): String {
        return price.toString(currency)
    }

    companion object {
        private val allergens = mapOf(
                Pair(AllergenEnum.GLUTEN, R.id.allergen01),
                Pair(AllergenEnum.CRUSTACEOS,R.drawable.ic_alergeno_02_crustaceos),
                Pair(AllergenEnum.HUEVO, R.drawable.ic_alergeno_03_huevo),
                Pair(AllergenEnum.CRUSTACEOS,R.drawable.ic_alergeno_04_pescado),
                Pair(AllergenEnum.GLUTEN, R.drawable.ic_alergeno_05_cacahuete),
                Pair(AllergenEnum.SOJA,R.drawable.ic_alergeno_06_soja),
                Pair(AllergenEnum.LACTEOS, R.drawable.ic_alergeno_07_lacteos),
                Pair(AllergenEnum.FRUTOS_SECOS,R.drawable.ic_alergeno_08_frutos_secos),
                Pair(AllergenEnum.APIO, R.drawable.ic_alergeno_09_apio),
                Pair(AllergenEnum.MOSTAZA,R.drawable.ic_alergeno_10_mostaza),
                Pair(AllergenEnum.SESAMO, R.drawable.ic_alergeno_11_sesamo),
                Pair(AllergenEnum.SULFITOS,R.drawable.ic_alergeno_12_sulfitos),
                Pair(AllergenEnum.ALTRAMUCES, R.drawable.ic_alergeno_13_altramuces),
                Pair(AllergenEnum.MOLUSCOS,R.drawable.ic_alergeno_14_moluscos)
        )

        fun getIcon(allergen: AllergenEnum) : Int {
            return allergens[allergen]!!
        }


    }
}