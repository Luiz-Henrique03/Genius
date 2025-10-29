package com.example.genius

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.genius.databinding.ActivityGeniusBinding
import kotlin.random.Random

class Genius : AppCompatActivity() {

    private lateinit var binding: ActivityGeniusBinding
    private lateinit var buttons: List<Button>

    private val sequence = mutableListOf<Int>()
    private val playerSequence = mutableListOf<Int>()
    private var round = 0
    private var maxRounds = 5 // Valor padrão
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeniusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recebe o número de rodadas da MainActivity
        maxRounds = intent.getIntExtra("MAX_ROUNDS", 5)

        buttons = listOf(binding.BtnRed, binding.BtnGreen, binding.BtnBlue, binding.BtnYellow)

        startNewGame()
    }

    private fun startNewGame() {
        round = 0
        sequence.clear()
        playerSequence.clear()
        nextRound()
    }

    private fun nextRound() {
        round++
        // Atualiza o texto do contador de rodadas
        binding.txtRound.text = "Round: $round"
        playerSequence.clear()
        sequence.add(Random.nextInt(0, 4))
        playSequence()
    }

    private fun playSequence() {
        enableButtons(false)
        var delay = 600L
        for (index in sequence) {
            handler.postDelayed({
                blink(buttons[index])
            }, delay)
            delay += 700
        }

        handler.postDelayed({
            enableButtons(true)
        }, delay)
    }

    private fun blink(button: Button) {
        val anim = AlphaAnimation(0.3f, 1.0f).apply {
            duration = 300
            repeatMode = Animation.REVERSE
            repeatCount = 1
        }
        button.startAnimation(anim)
    }

    private fun enableButtons(enable: Boolean) {
        for (btn in buttons) {
            btn.isEnabled = enable
            btn.setOnClickListener {
                if (enable) onButtonClick(btn)
            }
        }
    }

    private fun onButtonClick(button: Button) {
        val index = buttons.indexOf(button)
        blink(button)
        playerSequence.add(index)

        if (!checkPlayerMove()) {
            openEndScreen(false)
            return
        }

        if (playerSequence.size == sequence.size) {
            // Condição de vitória baseada no maxRounds definido pelo usuário
            if (round == maxRounds) {
                openEndScreen(true)
            } else {
                enableButtons(false)
                handler.postDelayed({ nextRound() }, 1000)
            }
        }
    }

    private fun checkPlayerMove(): Boolean {
        val last = playerSequence.size - 1
        return playerSequence[last] == sequence[last]
    }

    private fun openEndScreen(victory: Boolean) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("victory", victory)
        startActivity(intent)
        finish()
    }
}