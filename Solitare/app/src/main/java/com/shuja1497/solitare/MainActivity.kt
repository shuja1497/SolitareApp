package com.shuja1497.solitare

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1

// implementing game view and its method
class MainActivity : AppCompatActivity() , GameView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame() // setting up the game .

        // leaving 4dp on left and right and having 7 cards .
        val cardWidth = (displayMetrics.widthPixels - dip(8))/7
        val cardHeight = cardWidth * (190/140) // must be in same ratio as in the resource folder.

        //linear layout with vertical orientation
        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
//                imageView(imageResource=cardBackDrawable).lparams(cardWidth, cardHeight)// deck
                deckView ().lparams(cardWidth, cardHeight)
                imageView(imageResource=emptyPileDrawable).lparams(cardWidth, cardHeight)// waste pile
                view().lparams(cardWidth, 0) // for a space btwn waste pile and foundation pile
                for (i in 0..3){
                    imageView(imageResource=emptyPileDrawable).lparams(cardWidth, cardHeight)// waste pile
                }
            }
            linearLayout {
            }
        }
    }

    override fun update(model: GameModel) {

    }
}
