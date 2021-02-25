package com.sanket.assignment.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.res.TypedArrayUtils.getString
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sanket.assignment.R

object MyUtils {
    fun showToastMsg(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showErrorLog(errorMsg: String) {
        Log.e(Resources.getSystem().getString(R.string.error), errorMsg)
    }

    fun showImage(context: Context, imgUrl: String, view: ImageView) {
        Glide.with(context).load(imgUrl).override(400,400).diskCacheStrategy(DiskCacheStrategy.ALL).into(view)
    }

}