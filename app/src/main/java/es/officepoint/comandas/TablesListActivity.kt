package es.officepoint.comandas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import es.officepoint.comandas.adapter.TablesAdapter
import es.officepoint.comandas.model.Tables
import kotlinx.android.synthetic.main.activity_main.*

class TablesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lvTables.adapter = TablesAdapter(this, Tables.tables)
        lvTables.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Click on " + Tables.tables[position].name, Toast.LENGTH_SHORT).show()

            var intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("table_id", position)
            startActivity(intent)
        }
    }
}
