package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View

import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.content_admin.*

class Admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun editQuizz(view: View) {
        val editQuestion = editQuestion.text.toString()
        val editAnswer1 = editAnswer_1.text.toString()
        val editAnswer2 = editAnswer_2.text.toString()
        val editAnswer3 = editAnswer_3.text.toString()
        val editCorrectResponse = editCorrectResponse.text.toString()

        val quiz = ArrayList<QuizzData>()

        quiz.add(QuizzData(editQuestion, editAnswer1, editAnswer2, editAnswer3, editCorrectResponse.toInt()))
        val quizzActivity = Intent(this, Quizz::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, quiz)
        }
        startActivity( Intent(quizzActivity))
    }
}
