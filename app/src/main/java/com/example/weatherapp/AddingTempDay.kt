package com.example.weatherapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class AddingTempDay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_temp_day)

        var sharedPreferences : SharedPreferences = this.getSharedPreferences("com.example.weatherapp",
            MODE_PRIVATE
        )

        val dropdown = findViewById<Spinner>(R.id.dayDrop)

        val items = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        val adapter = ArrayAdapter(this, androidx.transition.R.layout.support_simple_spinner_dropdown_item, items)

        dropdown.adapter = adapter
    }
}