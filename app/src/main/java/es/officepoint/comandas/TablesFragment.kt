package es.officepoint.comandas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import es.officepoint.comandas.adapter.TablesAdapter
import es.officepoint.comandas.model.Table
import es.officepoint.comandas.model.Tables
import kotlinx.android.synthetic.main.activity_tables.*

class TablesFragment: Fragment() {

    lateinit var clickListener : OnItemClickListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnItemClickListener)
            clickListener = context
        else
            throw IllegalArgumentException("Attached activity doesn't implement TablesFragment.OnItemClickListener")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tables, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lvTables?.adapter = TablesAdapter(context!!, Tables.tables)
        lvTables?.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _->
            //Toast.makeText(this, "Click on " + Tables.tables[position].name, Toast.LENGTH_SHORT).show()
            clickListener.onItemClicked(position)
          //  val intent = Intent(context, OrderActivity::class.java)
           // intent.putExtra("table_id", position)
            //startActivity(intent)
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(tableId: Int)
    }


}