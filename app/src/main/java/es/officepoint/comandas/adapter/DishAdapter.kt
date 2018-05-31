package es.officepoint.comandas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import es.officepoint.comandas.R
import es.officepoint.comandas.model.DishesRepo
import kotlinx.android.synthetic.main.item_dish.view.*

class DishAdapter : BaseAdapter(){
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

        vh.dishName.text = DishesRepo.dishes[p0].name
        vh.dishIcon.setImageResource(DishesRepo.dishes[p0].icon)
        val textPrice = "${DishesRepo.dishes[p0].price} €"
        vh.dishPrice.text = textPrice

        return view
    }

    override fun getItem(p0: Int): Any {
        return DishesRepo.dishes[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return DishesRepo.dishes.size
    }

    inner class DishViewHolder(row: View){
        val dishName = row.findViewById(R.id.dishName) as TextView
        val dishIcon = row.findViewById(R.id.dishIcon) as ImageView
        val dishPrice = row?.findViewById(R.id.dishPrice) as TextView
    }

}