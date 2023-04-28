package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dice_roller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewbinding code
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

//        role button action
        binding.button.setOnClickListener {
//            toast to show that the dice has rolled

            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()

            //dicerolling function
            rolldice()

        }


    }

    private fun rolldice() {
        //getting random value from dice roll
        val dice=Dice(6)
        val rollresult = dice.roll()

        //setting image corresponding to the result of the dice roll
        val diceiamge = binding.imageView

        //using when statement for applying conditions
        val drawableres= when(rollresult){

            1->R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        //setting image to imageview corresponding to the result of the dice
        diceiamge.setImageResource(drawableres)

    }

    class Dice (val sides :Int)

    {
        fun roll() :Int{
            return( 1..sides).random()

        }
    }
}