package com.example.motionlayoutsample.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.example.motionlayoutsample.R
import kotlinx.android.synthetic.main.motion_second_fragment.*

class SecondFragment : Fragment() {

    var motionLayout: MotionLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.motion_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motionLayout = main
    }

    override fun onStart() {
        super.onStart()
        Log.i(SecondFragment::class.java.simpleName, "onStart of fragment...")
    }
}
