package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName :TextView = findViewById(R.id.tv_name)
        val tvScore :TextView = findViewById(R.id.tv_score)
        val btnSubmit : Button = findViewById(R.id.btn_finish)
        val mCorrectAns = intent.getIntExtra(Constants.correctAns,0)
        tvName.text = intent.getStringExtra(Constants.userName)
        tvScore.text = "Your score is $mCorrectAns out of 10"

        btnSubmit.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}