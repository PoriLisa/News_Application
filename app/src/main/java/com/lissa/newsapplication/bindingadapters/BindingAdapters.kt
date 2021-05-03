package com.neyyar.learning.bindingadapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.lissa.newsapplication.R
import com.lissa.newsapplication.helpers.Utils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl).apply(RequestOptions())
        .placeholder(R.drawable.ic_launcher_background)
        .into(view)

}

@BindingAdapter("setDate")
fun setDate(view: TextView, isoTime: String) {

    val date = Utils.convertISOTimeToDate(isoTime)
    view.setText(date)


}

