package com.example.mygarage

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


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
    }

    // генерируем данные для адаптера
    fun fillData() {
        for (i in 1..20) {
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