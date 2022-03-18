package com.fady.marvelcomics.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.CharactersResponse

object ViewUtils {
    fun Context.getColorCompat(color: Int) = ContextCompat.getColor(this, color)

    fun Context.glidePlaceHolder(): CircularProgressDrawable {
        return CircularProgressDrawable(this).apply {
            strokeWidth = 5f
            centerRadius = 30f
            setColorSchemeColors(getColorCompat(R.color.red))
            start()
        }
    }


    fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) =
        this?.let { Toast.makeText(it, textId, duration).show() }

    fun formatImageUrl(image: CharactersResponse.Data.Result.Thumbnail): String {
        return image.path + "." + image.extension
    }


}