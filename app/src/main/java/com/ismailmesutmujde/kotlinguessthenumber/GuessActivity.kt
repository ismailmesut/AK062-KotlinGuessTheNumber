package com.ismailmesutmujde.kotlinguessthenumber

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinguessthenumber.databinding.ActivityGuessBinding

class GuessActivity : AppCompatActivity() {

    private lateinit var bindingGuess : ActivityGuessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingGuess = ActivityGuessBinding.inflate(layoutInflater)
        val view = bindingGuess.root
        setContentView(view)

        bindingGuess.buttonGuess.setOnClickListener {
            val intent = Intent(this@GuessActivity, ResultActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}