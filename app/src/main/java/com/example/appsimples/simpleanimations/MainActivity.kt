package com.example.appsimples.simpleanimations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpListeners()

        setUpImageRotation(rotateInfiniteImage)

        setUpImageRotation(rotateInfiniteReverseImage, true)

    }

    private fun setUpImageRotation(imageView: ImageView, isReverse: Boolean = false) {
        //RotateAnimation constructor, here is possible to change rotation pivot (center of rotation)
        //In this case the center of rotation is the center of the drawable
        val rotate = RotateAnimation(
            0F,
            360F,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5F
        )
        rotate.duration = 2000                      //animation duration in milli seconds
        rotate.interpolator =
                LinearInterpolator()  //Interpolator to control animation style, see interpolator types for more info
        rotate.repeatCount = Animation.INFINITE     //How many times repeat animation
        if (isReverse) {
            rotate.repeatMode = Animation.REVERSE   //Reverse animation on every cycle
        } else {
            rotate.repeatMode = Animation.RESTART   //Do not reverse animation (Standard)
        }
        imageView.startAnimation(rotate)
    }

    private fun setUpListeners() {
        //JUST TO INCREASE CLICK AREA, click listener is on FrameLayout
        simpleLikeContainer.setOnClickListener {
            simpleLikeButton.isChecked = !simpleLikeButton.isChecked
            //do your button action here
        }
    }
}
