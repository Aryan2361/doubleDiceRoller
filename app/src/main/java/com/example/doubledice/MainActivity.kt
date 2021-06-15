package com.example.doubledice

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            rollDice(imageView,imageView2)
        }

        rollDice(imageView,imageView2)
    }
}

class Dice(private val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}

fun rollDice(img1: ImageView, img2:ImageView){
    val dice1=Dice(6)
    val dice2=Dice(6)

    val diceRoll1=dice1.roll()
    val diceRoll2=dice2.roll()

    img1.contentDescription=diceRoll1.toString()
    img2.contentDescription=diceRoll2.toString()

    val drawable1:Int=when(diceRoll1){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }

    val drawable2:Int=when(diceRoll2){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }

    img1.setImageResource(drawable1)
    img2.setImageResource(drawable2)
}