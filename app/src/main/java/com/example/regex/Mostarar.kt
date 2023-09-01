package com.example.regex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.regex.databinding.ActivityMostararBinding

class Mostarar : AppCompatActivity() {
    lateinit var binding: ActivityMostararBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMostararBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}