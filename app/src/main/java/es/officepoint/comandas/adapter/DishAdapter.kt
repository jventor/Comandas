package es.officepoint.comandas.adapter

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import es.officepoint.comandas.R
import android.content.Context
import es.officepoint.comandas.model.Dish

import es.officepoint.comandas.model.DishesRepo
import kotlinx.android.synthetic.main.item_dish.view.*

class DishAdapter (private val context: Context) : BaseAdapter(){

    lateinit var dish : Dish

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
        val view: View
        val vh : DishViewHolder

        if (p1 == null) {
            view = LayoutInflater.from(p2.context).inflate(R.layout.item_dish, p2,false)
            vh = DishViewHolder(view)
            view.tag = vh
        }
        else {
            view = p1
            vh = view.tag as DishViewHolder
        }
        dish = DishesRepo.dishes[p0]

        vh.dishName.text = dish.name
        vh.dishIcon.setImageResource(dish.icon)
        vh.dishPrice.text = dish.getPriceString(context.getString(R.string.currency))

        if (p0 % 2 == 0) {
            vh.container.setBackgroundColor(ContextCompat.getColor(context, R.color.colorLightGray))
        }
        else{
            vh.container.setBackgroundColor(Color.WHITE)
        }

        DishesRepo.dishes[p0].allergen.forEach {
            vh.allergens[it.ordinal].alpha = 1.0F
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return dish
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return DishesRepo.dishes.size
    }

    inner class DishViewHolder(row: View?){
        val dishName = row?.findViewById(R.id.dishName) as TextView
        val dishIcon = row?.findViewById(R.id.dishIcon) as ImageView
        val dishPrice = row?.findViewById(R.id.dishPrice) as TextView
        val container = row?.findViewById(R.id.container) as ConstraintLayout
        val allergens : List<ImageView> = listOf(
                row?.findViewById(R.id.allergen01) as ImageView,
                row.findViewById(R.id.allergen02) as ImageView,
                row.findViewById(R.id.allergen03) as ImageView,
                row.findViewById(R.id.allergen04) as ImageView,
                row.findViewById(R.id.allergen05) as ImageView,
                row.findViewById(R.id.allergen06) as ImageView,
                row.findViewById(R.id.allergen07) as ImageView,
                row.findViewById(R.id.allergen08) as ImageView,
                row.findViewById(R.id.allergen09) as ImageView,
                row.findViewById(R.id.allergen10) as ImageView,
                row.findViewById(R.id.allergen11) as ImageView,
                row.findViewById(R.id.allergen12) as ImageView,
                row.findViewById(R.id.allergen13) as ImageView,
                row.findViewById(R.id.allergen14) as ImageView
        )
    }

}