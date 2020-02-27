package com.example.motionlayoutsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motionlayoutsample.fragments.MotionFragmentsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonTutorial.setOnClickListener { startActivity(Intent(this, MotionPagerActivity::class.java)) }
        buttonCollapse.setOnClickListener { startActivity(Intent(this, CollapseToolbarActivity::class.java)) }
        buttonCollapseText.setOnClickListener { startActivity(Intent(this, CollapseToolbarActivityText::class.java)) }
        buttonVan.setOnClickListener { startActivity(Intent(this, VanGoghActivity::class.java)) }
        buttonMi.setOnClickListener { startActivity(Intent(this, MiActivity::class.java)) }
        buttonYoutube.setOnClickListener { startActivity(Intent(this, YouTubeActivity::class.java))}
        buttonFragment.setOnClickListener { startActivity(Intent(this, MotionFragmentsActivity::class.java)) }
        buttonCarousel.setOnClickListener { startActivity(Intent(this, CarouselActivity::class.java)) }
        buttonNavigation.setOnClickListener { startActivity(Intent(this, SideMenusActivity::class.java)) }
    }
}
