package com.example.productstore

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.example.productstore.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selected = mutableListOf<String>()
        var sal = false
        var dost = ""
        var tip = 0
        var SnackStr =""
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val products = arrayListOf(binding.CB1, binding.CB2, binding.CB3, binding.CB4, binding.CB5,binding.CB6)
        setContentView(binding.root)
        binding.Btn.setOnClickListener(){
            for(i in products){
                if(i.isChecked){
                    selected.add(i.text.toString())
                }
            }
            if((binding.RG[0] as RadioButton).isChecked){
                dost =(binding.RG[0] as RadioButton).text.toString()
            }
            else if((binding.RG[1] as RadioButton).isChecked){
                dost =(binding.RG[1] as RadioButton).text.toString()

            }
            else if((binding.RG[2] as RadioButton).isChecked){
                dost =(binding.RG[2] as RadioButton).text.toString()

            }
            sal = binding.S.isChecked
            tip = binding.Ed.text.toString().toInt()
            if(sal){
                SnackStr="Продукты: ${selected}; Доставка: $dost, Положить салфетки; Чаевые: $tip руб"
            }
            else{
                SnackStr="Продукты: ${selected}; Доставка: $dost, Не класть салфетки; Чаевые: $tip руб"
            }
            Snackbar.make(binding.root, SnackStr, Snackbar.LENGTH_SHORT).show()
            selected.clear()
        }

    }
}