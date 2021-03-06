package es.officepoint.comandas.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import es.officepoint.comandas.R
import es.officepoint.comandas.model.Table

class TablesAdapter(private var context: Context, private var tablesList: List<Table>) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        val view: View?
        val vh: ListRowHolder

        if (p1 == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_table, p2, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = p1
            vh = view.tag as ListRowHolder
        }

        vh.tableName.text = tablesList[p0].name
        if (tablesList[p0].orders.size == 0){
            vh.tableIcon.alpha = 0.15F
        }
        else{
            vh.tableIcon.alpha = 1F
        }
        return view
    }

    override fun getItem(p0: Int): Any {
        return tablesList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return tablesList.size
    }

    private class ListRowHolder(row: View?) {
        val tableName = row?.findViewById(R.id.tableName) as TextView
        val tableIcon = row?.findViewById(R.id.tableIcon) as ImageView
    }
}