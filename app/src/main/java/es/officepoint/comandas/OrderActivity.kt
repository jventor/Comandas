package es.officepoint.comandas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import es.officepoint.comandas.adapter.OrderAdapter
import es.officepoint.comandas.model.Tables
import kotlinx.android.synthetic.main.activity_table_detail.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        val tableId = intent.getIntExtra("table_id",0)
        tableName.text = Tables.tables[tableId].name

        lvOrder.adapter = OrderAdapter(Tables.tables[tableId].order)
    }
}
