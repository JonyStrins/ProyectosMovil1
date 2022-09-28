package com.example.mirecyclerviews.data

import android.content.res.Resources
import com.example.mirecyclerviews.R

fun listFlowers (val recursos: Resources) : List<Flower>{
    return listOf(
        Flower(1, recursos.getString(R.string.flower1_name), R.drawable.rose, recursos.getString(R.string.flower1_description)),
        Flower(2, recursos.getString(R.string.flower2_name), R.drawable.freesia, recursos.getString(R.string.flower2_description)),
        Flower(3, recursos.getString(R.string.flower3_name), R.drawable.lily, recursos.getString(R.string.flower3_description))
    )
}