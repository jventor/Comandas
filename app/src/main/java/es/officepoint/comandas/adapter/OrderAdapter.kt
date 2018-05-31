package es.officepoint.comandas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import es.officepoint.comandas.R

import es.officepoint.comandas.model.Order


class OrderAdapter (private val order: List<Order>) : BaseAdapter(){


    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View? {
        val view : View?
        val vh : OrderViewHolder

        if (p1 == null){
            view = LayoutInflater.from(p2.context).inflate(R.layout.item_order, p2, false)
            vh = OrderViewHolder(view)
            view.tag = vh
        }
        else {
            view = p1
            vh = view.tag as OrderViewHolder
        }
        vh.dishName.text = order[p0].dish.name
        vh.dishIcon.setImageResource(order[p0].dish.icon)
        val priceText = order[p0].dish.price.toString() + " €"
        vh.dishPrice.text = priceText
        vh.dishVariant.text = "Los caphicos de la gente a la hora de comer"

        return view
    }

    override fun getItem(p0: Int): Any {
        return order[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return order.size
    }

    private class OrderViewHolder(row: View?){
        public val dishName = row?.findViewById(R.id.dishName) as TextView
        public val dishIcon = row?.findViewById(R.id.dishIcon) as ImageView
        public val dishPrice = row?.findViewById(R.id.dishPrice) as TextView
        public val dishVariant = row?.findViewById(R.id.dishVariant) as TextView
    }
}