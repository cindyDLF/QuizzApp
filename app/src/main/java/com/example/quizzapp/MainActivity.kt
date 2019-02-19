package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getusername() {
         username = inputName.text.toString()
    }

    fun btnQuizz(view: View) {

        val quizzActivity = Intent(this,Quizz::class.java).apply { putExtra(AlarmClock.EXTRA_MESSAGE, inputName.text.toString()) }
        startActivity( Intent(quizzActivity))
    }

    fun btnAdmin(view: View) {
        val adminActivity = Intent(this, Admin::class.java).apply { putExtra(AlarmClock.EXTRA_MESSAGE, inputName.text.toString()) }
        startActivity( Intent(adminActivity))
    }
}
