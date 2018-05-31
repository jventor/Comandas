package es.officepoint.comandas

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import es.officepoint.comandas.adapter.OrderAdapter
import es.officepoint.comandas.model.Dish
import es.officepoint.comandas.model.DishesRepo
import es.officepoint.comandas.model.Order
import es.officepoint.comandas.model.Tables
import kotlinx.android.synthetic.main.activity_table_detail.*

class OrderActivity : AppCompatActivity() {

    val REQUEST_DISH = 1

    var tableId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        tableId = intent.getIntExtra("table_id",0)
        tableName.text = Tables.tables[tableId].name

        lvOrder.adapter = OrderAdapter(Tables.tables[tableId].orders)

        btnAddDish.setOnClickListener {
            //Tables.tables[tableId].orders.add(Order(DishesRepo.dishes.first()))
            //(lvOrder.adapter as OrderAdapter).notifyDataSetChanged()
            //val intent = Intent(this, DishesActivity::class.java)
            //startActivity(intent)
            startActivityForResult(DishesActivity.intent(this), REQUEST_DISH)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            REQUEST_DISH -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    val position = data.getIntExtra(DishesActivity.EXTRA_DISH,0)
                    Tables.tables[tableId].orders.add(Order(DishesRepo.dishes[position]))
                    (lvOrder.adapter as OrderAdapter).notifyDataSetChanged()
                }
            }
        }
    }
}
