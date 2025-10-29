package com.example.genius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.genius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val victory = intent.getBooleanExtra("victory", false)

        if (victory) {
            binding.txtResult.text = "🎉 Você venceu! 🎉"
            binding.txtResult.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            binding.txtResult.text = "😢 Você perdeu!"
            binding.txtResult.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        }

        binding.btnRetry.setOnClickListener {
            val intent = Intent(this, Genius::class.java)
            startActivity(intent)
            finish()
        }
    }
}
