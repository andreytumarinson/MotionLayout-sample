package com.example.motionlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_collapsing_toolbar_start.*
import kotlinx.android.synthetic.main.text_list_item.view.*

class CollapseToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_start)

        recyclerView.apply {
            adapter = DummyListAdapter()
            layoutManager = LinearLayoutManager(this@CollapseToolbarActivity)
        }
    }
}

class DummyListAdapter : RecyclerView.Adapter<DummyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyListAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.text_list_item, parent, false) as ConstraintLayout
        )
    }

    override fun getItemCount() = 15

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textView.text = "Sample item $position"
    }

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

}
