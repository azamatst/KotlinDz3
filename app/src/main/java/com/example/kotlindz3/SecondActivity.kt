package com.example.kotlindz3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindz3.adapters.GoatAdapters
import com.example.kotlindz3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var goatAdapters: GoatAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val a = intent.getIntegerArrayListExtra(MainActivity.MAIN_ACTIVITY_EXTRA)
        goatAdapters = GoatAdapters(a as ArrayList<Int>)
        binding.recyclerView.adapter  = goatAdapters

    }
}