package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.R.*

class QuizQuestions : AppCompatActivity() {
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? =null
    private var selectedOptionPosition : Int =0
    private var userCorrectAns : Int = 0
    private var mUserName :String? = null

    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var btnOpt1 : TextView? = null
    private var btnOpt2 : TextView? = null
    private var btnOpt3 : TextView? = null
    private var btnOpt4 : TextView? = null
    private var btnSubmit : Button? = null
    private var isSubmit : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.userName)

        tvQuestion  = findViewById(id.tv_question)
        ivImage  = findViewById(id.iv_flag)
        progressBar  = findViewById(id.progress_bar)
        tvProgress  = findViewById(id.tv_progress)
        btnOpt1  = findViewById(id.tv_option_one)
        btnOpt2  = findViewById(id.tv_option_two)
        btnOpt3  = findViewById(id.tv_option_three)
        btnOpt4 = findViewById(id.tv_option_four)
        btnSubmit  = findViewById(id.btn_submit)

        mQuestionList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition-1]
        selectedOptionPosition=0
        isSubmit=false
        defaultView()

        progressBar?.progress = mCurrentPosition
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        btnOpt1?.text = question.optionOne
        btnOpt2?.text = question.optionTwo
        btnOpt3?.text = question.optionThree
        btnOpt4?.text = question.optionFour

        tvProgress?.text = "${mCurrentPosition}" + "/" + progressBar?.getMax()

        btnSubmit?.setOnClickListener {
            onSubmit(question,selectedOptionPosition)
        }

        btnOpt1?.setOnClickListener {
            selectedOptionPosition=1
            onOptionClick(it)
        }

        btnOpt2?.setOnClickListener {
            selectedOptionPosition=2
            onOptionClick(it)
        }

        btnOpt3?.setOnClickListener {
            selectedOptionPosition=3
            onOptionClick(it)
        }

        btnOpt4?.setOnClickListener {
            selectedOptionPosition=4
            onOptionClick(it)
        }

        btnSubmit?.text="SUBMIT"
    }

    private fun onOptionClick(it:View) {
        defaultView()

        it.background = ContextCompat.getDrawable(
            this@QuizQuestions,
            drawable.selected_option_border
        )

    }

    private fun defaultView(){
        val options = ArrayList<TextView>()
        btnOpt1?.let {
            options.add(0, it)
        }
        btnOpt2?.let {
            options.add(1, it)
        }
        btnOpt3?.let {
            options.add(2, it)
        }
        btnOpt4?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestions,
                drawable.border_background
            )
        }
    }

    private fun onSubmit(question: Question, selectedOptionPosition: Int) {
        if(selectedOptionPosition!=0){
            if(!isSubmit){
                if(selectedOptionPosition!=question.correctAns){
                    answerView(selectedOptionPosition, drawable.wrong_ans_bg)
                }else{
                    userCorrectAns++
                }
                answerView(question.correctAns, drawable.correct_ans_bg)
                if(mCurrentPosition==mQuestionList!!.size){
                    btnSubmit?.text ="FINISH"
                }else{
                    btnSubmit?.text = "GO TO NEXT QUESTION"
                }
                isSubmit=true
            }else{
                mCurrentPosition++
                if(mCurrentPosition<=mQuestionList!!.size){
                    setQuestion()
                }else{
                    Log.i("Yes","Score is $userCorrectAns")
                    mUserName?.let { Log.i("UserName at quiz", it) }
                    val intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra(Constants.userName,mUserName.toString())
                    intent.putExtra(Constants.correctAns,userCorrectAns)
                    startActivity(intent)
                    finish()
                }
            }
        }else{
            Toast.makeText(this@QuizQuestions,"Please select a option",Toast.LENGTH_SHORT)
                .show()
        }


    }

    private fun answerView(selectedOptionPosition: Int, drawableView: Int) {
        when (selectedOptionPosition) {
            1 -> {
                btnOpt1?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
                btnOpt1?.setTextColor(Color.parseColor("#FF000000"))
            }
            2 -> {
                btnOpt2?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
                btnOpt2?.setTextColor(Color.parseColor("#FF000000"))
            }
            3 -> {
                btnOpt3?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
                btnOpt3?.setTextColor(Color.parseColor("#FF000000"))
            }
            4 -> {
                btnOpt4?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawableView
                )
                btnOpt4?.setTextColor(Color.parseColor("#FF000000"))
            }
        }
    }


}