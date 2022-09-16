package com.example.mvc_example.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvc_example.databinding.OderMainBinding
import com.example.mvc_example.model.Americano
import com.example.mvc_example.model.TotalPrice

class OderActivity : AppCompatActivity() {
    private lateinit var binding:OderMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OderMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val americanoModel = Americano()
        val totalPriceModel = TotalPrice()

        binding.americanoDeleteButton.setOnClickListener {
            americanoModel.delete()
            binding.americanoCountText.text = "${americanoModel.quantity}"
            totalPriceModel.decreaseTotalPrice(americanoModel.price)
            binding.totalPriceText.text = "${totalPriceModel.totalPrice}"
        }

        binding.americanoAddButton.setOnClickListener {
            americanoModel.add()
            binding.americanoCountText.text = "${americanoModel.quantity}"
            totalPriceModel.increaseTotalPrice(americanoModel.price)
            binding.totalPriceText.text = "${totalPriceModel.totalPrice}"
        }
    }
}