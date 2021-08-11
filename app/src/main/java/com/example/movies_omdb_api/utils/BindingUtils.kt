package com.example.movies_omdb_api.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView: ImageView, url: String?) {
            val context = imageView.context
            Glide.with(context)
                .load(url)
                .into(imageView)
        }
    }
}