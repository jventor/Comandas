package es.officepoint.comandas

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import es.officepoint.comandas.adapter.OrderAdapter
import es.officepoint.comandas.model.*
import kotlinx.android.synthetic.main.activity_table_detail.*

class OrderActivity : AppCompatActivity() {

    val REQUEST_DISH = 1

    private var tableId : Int = 0

    private lateinit var listAdapter : OrderAdapter

    lateinit var table : Table

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        tableId = intent.getIntExtra("table_id",0)
        table = Tables.tables[tableId]
        tableName.text = table.name
        listAdapter = OrderAdapter(this, table.orders)
        lvOrder.adapter = listAdapter

        lvOrder.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            showDishDialog(table.orders[position])
        }

        btnAddDish.setOnClickListener {
            startActivityForResult(DishesActivity.intent(this), REQUEST_DISH)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            REQUEST_DISH -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    val position = data.getIntExtra(DishesActivity.EXTRA_DISH,0)
                    val variant = data.getStringExtra(DishesActivity.EXTRA_VARIANTS)
                    table.orders.add(Order(DishesRepo.dishes[position],variant))
                    listAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_table_detail,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_bill-> {
                showBillDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDishDialog(order: Order){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_dish, null)
        dialogBuilder.setView(dialogView)

        val dishIcon = dialogView.findViewById(R.id.dishIcon) as ImageView
        val dishPrice = dialogView.findViewById(R.id.dishPrice) as TextView
        val dishName = dialogView.findViewById(R.id.dishName) as TextView
        val editText = dialogView.findViewById(R.id.txtVariants) as EditText

        dialogBuilder.setTitle(getString(R.string.dish_selection))
        dishIcon.setImageResource(order.dish.icon)
        dishPrice.text = order.dish.price.toString(getString(R.string.currency))
        dishName.text = order.dish.name
        editText.setText(order.variant)

        dialogBuilder.setPositiveButton(getString(R.string.Accept)){ _, _ ->
            order.variant = editText.text.toString()
        }

        dialogBuilder.setNegativeButton(getString(R.string.Delete)){ _, _ ->
            val position = table.getOrderIndex(order)
            table.orders.removeAt(position)
            listAdapter.notifyDataSetChanged()
        }
        val b = dialogBuilder.create()
        b.show()
    }

    private fun showBillDialog(){
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setTitle(getString(R.string.Bill))
        dialogBuilder.setMessage(table.getTotalPrice().toString(getString(R.string.currency)))
        dialogBuilder.setPositiveButton(getString(R.string.Charge)){ _, _ ->
            table.orders.clear()
            listAdapter.notifyDataSetChanged()
            finish()
        }
        dialogBuilder.setNegativeButton(getString(R.string.Cancel)){ _ , _ -> }
        val b = dialogBuilder.create()
        b.show()
    }
}
