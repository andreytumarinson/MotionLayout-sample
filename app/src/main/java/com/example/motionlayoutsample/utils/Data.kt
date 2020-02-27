package com.example.motionlayoutsample.utils

import com.example.motionlayoutsample.R
import java.io.Serializable

data class Item(val name: String, val image: Any): Serializable

val sampleGridData = listOf(
    Item("Gingerbread", R.drawable.img_lights),
    Item("Ice Cream Sandwich ", R.drawable.serf),
    Item("Jelly Bean", R.drawable.butterfly),
    Item("KitKat", R.drawable.image2),
    Item("Lollipop", R.drawable.serf),
    Item("Marshmallow", R.drawable.butterfly),
    Item("Nougat", R.drawable.image2),
    Item("Oreo", R.drawable.img_lights),
    Item("Pie", R.drawable.serf),
    Item("Qwerty", R.drawable.butterfly)
)