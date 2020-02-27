package com.example.motionlayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsample.utils.sampleGridData
import kotlinx.android.synthetic.main.activity_youtube_start.*
import kotlinx.android.synthetic.main.youtube_item_main.view.*

class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_start)

        mainRecycler.apply {
            adapter = YouTubeListAdapter()
            layoutManager = LinearLayoutManager(this@YouTubeActivity)
        }

        recyclerview_front.apply {
            adapter = FrontPhotosAdapter()
            layoutManager = LinearLayoutManager(this@YouTubeActivity)
        }
    }
}

class FrontPhotosAdapter : RecyclerView.Adapter<YouTubeDemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeDemoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.youtube_header_item -> YouTubeDemoViewHolder.TextHeaderViewHolder(itemView)
            R.layout.youtube_item -> YouTubeDemoViewHolder.CatRowViewHolder(itemView)
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: YouTubeDemoViewHolder, position: Int) {
        when (holder) {
            is YouTubeDemoViewHolder.TextHeaderViewHolder -> {}
            is YouTubeDemoViewHolder.CatRowViewHolder -> {
                val imagePosition = position - 1
                holder.textView.text = "Video title $imagePosition"
                holder.imageView.setImageResource(sampleGridData[imagePosition].image as Int)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> R.layout.youtube_header_item
            else -> R.layout.youtube_item
        }
    }

    override fun getItemCount() = sampleGridData.size +1 // For text header and text description
}

/**
 * [RecyclerView.ViewHolder] types used by this adapter.
 */
sealed class YouTubeDemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class TextHeaderViewHolder(
            itemView: View
    ) : YouTubeDemoViewHolder(itemView)

    class CatRowViewHolder(
            itemView: View
    ) : YouTubeDemoViewHolder(itemView) {
        val imageView = itemView.findViewById(R.id.image_row) as ImageView
        val textView = itemView.findViewById(R.id.text_row) as TextView
    }
}

class YouTubeListAdapter : RecyclerView.Adapter<YouTubeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.youtube_item_main, parent, false) as ConstraintLayout
        )
    }

    override fun getItemCount() = sampleGridData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.imageView.setImageResource(sampleGridData[position].image as Int)
        holder.itemView.title.text = "Video title $position"
        holder.itemView.author.text = "Channel $position"
    }

    class ViewHolder(val layout: ConstraintLayout) : RecyclerView.ViewHolder(layout)

}

