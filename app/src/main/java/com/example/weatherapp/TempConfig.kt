package com.example.weatherapp

import android.content.SharedPreferences
import com.google.gson.Gson

fun calculateAverage(input: List<Int>?): Int? {
        var total = 0

        if (input != null){
            for (num in input){
                total += num
            }
            if (total > 0 && total != null) {
                return total / input.count()
            }else{
                return null
            }
        }
        return null
    }

fun pushTempTonList(sharedPreferences: SharedPreferences): List<Int>{
    var i = 0
    var list: List<Int> = mutableListOf()
    while(i < 6){

        val gson = Gson()
        val json: String? = sharedPreferences.getString("Temps", "")
        val temp: Int = gson.fromJson(json, Int::class.java)
        list.toMutableList().add(temp)

        i++
    }
    return list

}

fun  addTempAndDay (input: Int, day: Int, sharedPreferences: SharedPreferences){

    var list = pushTempTonList(sharedPreferences)
    var i = 0
    while(i != day){
        if(list[i] == null){
            list.toMutableList().add(0)
            val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(list)
            prefsEditor.putString("Temps", json)
            prefsEditor.apply()
        }
    }
    if(input != null){

        list.toMutableList().add(input)

        val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(list)
        prefsEditor.putString("Temps", json)
        prefsEditor.apply()
    }



}