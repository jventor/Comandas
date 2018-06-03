package es.officepoint.comandas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import es.officepoint.comandas.adapter.TablesAdapter
import es.officepoint.comandas.model.Tables
import kotlinx.android.synthetic.main.activity_tables.*

class TablesListActivity : AppCompatActivity(), TablesFragment.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)

        val fragment = TablesFragment()

        if (savedInstanceState == null)
            this.supportFragmentManager
                    .beginTransaction()
                    .add(R.id.listTableContainer, fragment)
                    .commit()

        lvTables.adapter = TablesAdapter(this, Tables.tables)
    }

    override fun onRestart() {
        super.onRestart()
        (lvTables.adapter as TablesAdapter).notifyDataSetChanged()

    }

    override fun onItemClicked(tableId: Int) {
        if (isDetailViewAvailable())
            showFragmentsDetail(tableId)
        else
            showTableDetail(tableId)
    }

    private fun isDetailViewAvailable() = detailContainer != null

    private fun showFragmentsDetail(tableId: Int) {
        val orderFragment = OrderFragment()
        val args = Bundle()
        args.putInt("table_id", tableId)
        orderFragment.arguments = args
        supportFragmentManager.beginTransaction()
                .replace(R.id.detailContainer, orderFragment)
                .commit()
    }

    private fun showTableDetail(tableId : Int){
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("table_id", tableId)
        startActivity(intent)
    }
}
