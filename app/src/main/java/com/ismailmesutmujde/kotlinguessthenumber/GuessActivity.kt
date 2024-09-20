package com.ismailmesutmujde.kotlinguessthenumber

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinguessthenumber.databinding.ActivityGuessBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {

    private lateinit var bindingGuess : ActivityGuessBinding

    private var randomNumber = 0
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGuess = ActivityGuessBinding.inflate(layoutInflater)
        val view = bindingGuess.root
        setContentView(view)

        randomNumber = Random.nextInt(101) // 0-100
        Log.e("Random Number", randomNumber.toString())

        bindingGuess.buttonGuess.setOnClickListener {

            counter = counter - 1
            val guess = bindingGuess.editTextInput.text.toString().toInt()

            if(guess == randomNumber) {
                val intent = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result", true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(guess > randomNumber) {
                bindingGuess.textViewHelp.text = "DECREASE"
                bindingGuess.textViewRemainingGuess.text = "Your Remaining Guess : $counter"
            }
            if (guess < randomNumber) {
                bindingGuess.textViewHelp.text = "INCREASE"
                bindingGuess.textViewRemainingGuess.text = "Your Remaining Guess : $counter"
            }
            if (counter == 0) {
                val intent = Intent(this@GuessActivity, ResultActivity::class.java)
                intent.putExtra("result", false)
                finish()
                startActivity(intent)
            }
            bindingGuess.editTextInput.setText("")

        }

    }
}