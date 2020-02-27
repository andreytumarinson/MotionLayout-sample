package com.example.motionlayoutsample

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.custom_share_layout.*
import kotlinx.android.synthetic.main.activity_vah_gogh_start.*

class VanGoghActivity : AppCompatActivity(), MotionLayout.TransitionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vah_gogh_start)
        motionLayout.setTransitionListener(this)
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        if(p1 == R.layout.activity_van_gogh_end && p0?.currentState != -1) {
            doBounceAnimation(seenImage)
            doBounceAnimation(favImage)
            doBounceAnimation(shareImage)
        }

    }

    private fun doBounceAnimation(targetView: View) {
        val animator = ObjectAnimator.ofFloat(targetView, "translationY", 0f, -10f, 0f)
        animator.interpolator = BounceInterpolator()
        animator.duration = 500
        animator.start()
    }
}
