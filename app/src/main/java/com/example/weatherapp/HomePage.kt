package com.example.weatherapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson


class HomePage : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            //declarations
            val addBtn = findViewById<Button>(R.id.addBtn)
            val dailyBtn = findViewById<Button>(R.id.dailyBtn)
            var weeklyTemp = findViewById<TextView>(R.id.tempWeekly)

            var sharedPreferences :SharedPreferences = this.getSharedPreferences("com.example.weatherapp",
                MODE_PRIVATE
            )
            var listOfTemps = pushTempTonList(sharedPreferences)

            val averageTemp = calculateAverage(listOfTemps)

            if(averageTemp != null){
                weeklyTemp.text = averageTemp.toString()
            }else{
                weeklyTemp.text = "N/A"
            }

            addBtn.setOnClickListener{
                val intent = Intent(this, AddingTempDay::class.java)
                startActivity(intent)
            }
            dailyBtn.setOnClickListener{
                val intent = Intent(this, AddingTempDay::class.java)
                startActivity(intent)
            }
    }
}