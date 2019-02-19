package com.example.quizzapp

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.view.View

import kotlinx.android.synthetic.main.content_quizz.*
import kotlinx.android.synthetic.main.activity_quizz.*

import java.util.ArrayList

class Quizz : AppCompatActivity() {

    var completeQuizz = ArrayList<QuizzData>()

    var currentIndex = 0

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        completeQuizz.add(QuizzData("2 + 2 ?", "3", "4", "7", 2))
        completeQuizz.add(QuizzData("18 + 1 ?", "5", "9", "19", 3))
        completeQuizz.add(QuizzData("Russian's capital ?", "Paris", "Moscou", "Seoul", 2))

        questions(completeQuizz.get(currentIndex))
    }

    fun displayQuestion(choose: Int) {

        val quiz = completeQuizz[currentIndex]

        correctResponse(choose, quiz.correctResponse)

        currentIndex++
        if (currentIndex < completeQuizz.size) {

            questions(completeQuizz[currentIndex])
        } else {
            val sentence = "Your score is : "
            val finalScore = sentence + score
            AlertDialog.Builder(this)
                .setTitle("Game is finished")
                .setMessage(finalScore)
                .setPositiveButton("Restart", DialogInterface.OnClickListener { dialog, i ->
                    currentIndex = 0
                    score = 0
                    questions(completeQuizz[currentIndex])
                    //set what would happen when positive button is clicked
                }).show()
        }
    }

    fun questions(quizz: QuizzData) {

        questions.text = quizz.question
        response_1.text = quizz.firstResponse
        response_2.text = quizz.secondResponse
        response_3.text = quizz.thirdResponse
        score_text.text = score.toString()

    }

    fun onClickResponseOne(view: View) {
        displayQuestion(1)
    }

    fun onClickResponseTwo(view: View) {
        displayQuestion(2)
    }

    fun onClickResponseTree(view: View) {
        displayQuestion(3)

    }

    fun correctResponse(correctResponse: Int, choose: Int) {
        if (choose == correctResponse) {

            score += 1
        }
    }
}
