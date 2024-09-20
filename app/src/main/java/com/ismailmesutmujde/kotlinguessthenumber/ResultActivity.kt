package com.ismailmesutmujde.kotlinguessthenumber

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinguessthenumber.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var bindingResult : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingResult = ActivityResultBinding.inflate(layoutInflater)
        val view = bindingResult.root
        setContentView(view)

        val result = intent.getBooleanExtra("result", false)
        if (result) {
            bindingResult.textViewResult.text = "YOU WIN"
            bindingResult.imageViewResult.setImageResource(R.drawable.happy_image)
        } else {
            bindingResult.textViewResult.text = "YOU LOST"
            bindingResult.imageViewResult.setImageResource(R.drawable.sad_image)
        }

        bindingResult.buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity, GuessActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}