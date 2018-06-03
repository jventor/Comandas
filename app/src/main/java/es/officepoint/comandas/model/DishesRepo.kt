package es.officepoint.comandas.model

import es.officepoint.comandas.R

object DishesRepo {
    val dishes : List<Dish> = listOf(
            Dish("Refrescos", 2.0F, R.drawable.d_refrescos),
            Dish("Vino", 7.0F, R.drawable.d_vino, listOf(AllergenEnum.SULFITOS) ),
            Dish("Mojito",5.0F, R.drawable.d_mojito),
            Dish("Gin Tonic", 8.0F, R.drawable.d_gintonic),
            Dish("Gazpacho", 5.0F, R.drawable.d_gazpacho, listOf(AllergenEnum.APIO)),
            Dish("Coctel de gambas", 6.5F, R.drawable.d_coctelgambas, listOf(AllergenEnum.CRUSTACEOS)),
            Dish("Hamburguesa", 7.8F, R.drawable.d_hamburguesa, listOf(AllergenEnum.GLUTEN, AllergenEnum.MOSTAZA, AllergenEnum.HUEVO)),
            Dish("Perrito caliente", 2.0F, R.drawable.d_hotdog, listOf(AllergenEnum.GLUTEN, AllergenEnum.MOSTAZA)),
            Dish("Tortilla", 4.5F, R.drawable.d_tortilla, listOf(AllergenEnum.HUEVO)),
            Dish("Pizza", 4.95F, R.drawable.d_pizza, listOf(AllergenEnum.GLUTEN)),
            Dish("Costillas", 12.5F, R.drawable.d_costillas),
            Dish("Paella de marisco", 26.0F, R.drawable.d_paella_marisco, listOf(AllergenEnum.PESCADO,AllergenEnum.MOLUSCOS, AllergenEnum.CRUSTACEOS)),
            Dish("Pulpo", 7.60F, R.drawable.d_pulpo, listOf(AllergenEnum.MOLUSCOS)),
            Dish("Salmón", 5.90F, R.drawable.d_salmon, listOf(AllergenEnum.PESCADO)),
            Dish("Sardinas", 6.0F, R.drawable.d_sardinas, listOf(AllergenEnum.PESCADO)),
            Dish("Tarta de queso", 5.8F, R.drawable.d_tartaqueso, listOf(AllergenEnum.LACTEOS, AllergenEnum.GLUTEN)),
            Dish("Tiramisu", 4.95F, R.drawable.d_tiramisu, listOf(AllergenEnum.GLUTEN)),
            Dish("Cafe",1.0F, R.drawable.d_cafe)
    )

    fun getIndex(dish: Dish) = dishes.indexOf(dish)
}