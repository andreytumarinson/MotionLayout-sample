package com.example.motionlayoutsample

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_motion_pager.*
import kotlinx.android.synthetic.main.tutorial_item.view.*


class MotionPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_pager)

        viewPager.adapter = MyAdapter()
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (viewPager.adapter!!.count > 1) {
                    val prog = (position + positionOffset) / (viewPager.adapter!!.count - 1)
                    onboardingRoot.progress = prog
                    animationView.progress = prog * 0.8f
                }
            }

            override fun onPageSelected(position: Int) {

            }
        })

        previousButton.setOnClickListener { viewPager.currentItem = viewPager.currentItem - 1 }
        nextButton.setOnClickListener { viewPager.currentItem = viewPager.currentItem + 1 }
    }

    override fun onDestroy() {
        viewPager.clearOnPageChangeListeners()
        super.onDestroy()
    }
}

class MyAdapter : PagerAdapter() {
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return 3
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView =  LayoutInflater.from(container.context)
            .inflate(R.layout.tutorial_item, container, false)
        itemView.textView.text = "Title $position"
        if(position == 2) {
            itemView.textView.setTextColor(Color.parseColor("#aa111111"))
            itemView.textView2.setTextColor(Color.parseColor("#aa111111"))
        }
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }


}