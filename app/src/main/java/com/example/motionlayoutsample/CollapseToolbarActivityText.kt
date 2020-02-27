package com.example.motionlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_collapsing_toolbar_start.*

class CollapseToolbarActivityText : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_start_2)

        recyclerView.apply {
            adapter = DummyListAdapter()
            layoutManager = LinearLayoutManager(this@CollapseToolbarActivityText)
        }
    }
}