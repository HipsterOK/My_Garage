package com.example.mygarage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val intent = intent
        val id:Int=intent.getIntExtra("id", 0)

        val fuelCalc: Fragment = FuelCalc()
        replaceFragment(fuelCalc)
    }

    fun AppCompatActivity.replaceFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frag,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}