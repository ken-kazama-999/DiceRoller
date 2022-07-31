package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Roll a dice when app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with thr result.
     */
    private fun rollDice() {
        // create new dice objects having 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Find the Imsge view in the app layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Assigns the random result to variable "drawable Resource",and shows an image depending on the number of "dice roll"
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Displays the gotten Image as result in the app
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

//This Generates random Numbers for the dice
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}