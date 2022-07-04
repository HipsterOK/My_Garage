package com.example.mygarage

import android.R.attr.button
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import com.example.mygarage.R.layout.car_item


class CarAdapter(context: Context?, cars: ArrayList<Car>?):BaseAdapter(){
    var ctx: Context? = context
    var lInflater: LayoutInflater? = ctx?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    var objects: ArrayList<Car>? = cars

    // кол-во элементов
    override fun getCount(): Int {
        return objects!!.size
    }

    // элемент по позиции
    override fun getItem(position: Int): Any {
        return objects!![position]
    }

    // id по позиции
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // пункт списка
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        // используем созданные, но не используемые view
        var view = convertView
        if (view == null) {
            view = lInflater?.inflate(car_item, parent, false)
        }
        val p: Car = getCar(position)

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        (view!!.findViewById<View>(R.id.idCar) as TextView).setText(p.ID.toString())
        (view.findViewById<View>(R.id.nameCar) as TextView).setText(p.name)
        (view.findViewById<View>(R.id.plateCar) as TextView).setText(p.plate)
        val delCar = view.findViewById<View>(R.id.delCar) as Button
        // присваиваем чекбоксу обработчик
        delCar.setOnClickListener(View.OnClickListener {
            //TODO
        })
        // пишем позицию
        delCar.tag = position
        return view
    }

    // товар по позиции
    fun getCar(position: Int): Car {
        return getItem(position) as Car
    }
}