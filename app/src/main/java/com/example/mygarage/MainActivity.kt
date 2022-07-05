package com.example.mygarage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PackageManagerCompat.LOG_TAG


var cars: ArrayList<Car> = ArrayList<Car>()
var carAdapter: CarAdapter? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создаем адаптер
        fillData()
        carAdapter = CarAdapter(this, cars)

        // настраиваем список
        val lvMain = findViewById<View>(R.id.carList) as ListView
        lvMain.adapter = carAdapter
        lvMain.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val intent= Intent(this@MainActivity, MainFragmentActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }

    // генерируем данные для адаптера
    fun fillData() {
        for (i in 1..3) {
            cars.add(
                Car(
                    i,
                    "car $i",
                    "A$i$i$i AA102"
                )
            )
        }
    }
}