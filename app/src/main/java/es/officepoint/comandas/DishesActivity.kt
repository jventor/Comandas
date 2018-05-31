package es.officepoint.comandas

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import es.officepoint.comandas.adapter.DishAdapter
import es.officepoint.comandas.model.DishesRepo
import kotlinx.android.synthetic.main.activity_dishes.*

class DishesActivity : AppCompatActivity() {



    companion object {
        val EXTRA_DISH = "EXTRA_DISH"

        fun intent(context: Context) = Intent(context, DishesActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)

        lvDishes.adapter = DishAdapter()
        lvDishes.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val returnIntent = Intent()
            returnIntent.putExtra(EXTRA_DISH, position)

            setResult(Activity.RESULT_OK, returnIntent)

            finish()
        }

    }
}
