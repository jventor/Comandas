package es.officepoint.comandas

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import es.officepoint.comandas.adapter.DishAdapter
import es.officepoint.comandas.model.Dish
import es.officepoint.comandas.model.DishesRepo
import kotlinx.android.synthetic.main.activity_dishes.*
import kotlinx.android.synthetic.main.activity_tables.*

class DishesActivity : AppCompatActivity() {

companion object {
        val EXTRA_DISH = "EXTRA_DISH"
        val EXTRA_VARIANTS = "EXTRA_VARIANTS"

        fun intent(context: Context) = Intent(context, DishesActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)

        lvDishes.adapter = DishAdapter(this)
        lvDishes.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            showDishDialog(DishesRepo.dishes[position])

        }
    }

    private fun showDishDialog(dish: Dish){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_dish, null)
        dialogBuilder.setView(dialogView)

        val dishIcon = dialogView.findViewById(R.id.dishIcon) as ImageView
        val dishPrice = dialogView.findViewById(R.id.dishPrice) as TextView
        val dishName = dialogView.findViewById(R.id.dishName) as TextView
        val editText = dialogView.findViewById(R.id.txtVariants) as EditText

        dialogBuilder.setTitle(getString(R.string.dish_selection))
        dishIcon.setImageResource(dish.icon)
        dishPrice.text = dish.price.toString(getString(R.string.currency))
        dishName.text = dish.name

        dialogBuilder.setPositiveButton(getString(R.string.Add)){ _, _ ->
            val returnIntent = Intent()
            returnIntent.putExtra(EXTRA_DISH, DishesRepo.getIndex(dish))
            returnIntent.putExtra(EXTRA_VARIANTS, editText.text.toString())

            setResult(Activity.RESULT_OK, returnIntent)

            finish()
        }
        dialogBuilder.setNegativeButton(getString(R.string.Cancel)){ _, _ ->
            finish()
        }
        val b = dialogBuilder.create()
        b.show()
    }
}

