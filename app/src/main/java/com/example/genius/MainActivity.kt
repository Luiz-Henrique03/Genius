package com.example.genius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.genius.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnIniciar.setOnClickListener {
            val roundsStr = binding.editTxtRounds.text.toString()
            val maxRounds = if (roundsStr.isNotEmpty()) roundsStr.toInt() else 5

            val intent = Intent(this, Genius::class.java)
            intent.putExtra("MAX_ROUNDS", maxRounds)
            startActivity(intent)
        }
    }
}