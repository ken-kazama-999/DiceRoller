package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity helps the user to roll a dice
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        //Roll the dice when user presses button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with thr result.
     */
    private fun rollDice() {
        // create new dice objects having 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the text on the screen with the dice roll.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

//This Generates random Numbers for the dice
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}