package es.officepoint.comandas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import es.officepoint.comandas.R
import es.officepoint.comandas.model.Dish
import kotlinx.android.synthetic.main.item_order.*

class OrderAdapter (private val order: List<Dish>) : BaseAdapter(){


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
        vh.dishName.text = order[p0].name

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
    }
}