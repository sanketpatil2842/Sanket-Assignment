package com.sanket.assignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.sanket.assignment.R
import com.sanket.assignment.models.response.UserResponse
import com.sanket.assignment.utils.MyUtils

class UserDetailActivity : AppCompatActivity() {
    lateinit var txt_name: TextView
    lateinit var txt_userid: TextView
    lateinit var txt_location: TextView
    lateinit var btn_show_img: AppCompatButton
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setBackActionArrow()
        init()
        getBundleData()
    }

    fun init() {
        txt_name = findViewById(R.id.txt_name)
        txt_userid = findViewById(R.id.txt_userid)
        txt_location = findViewById(R.id.txt_location)
        btn_show_img = findViewById(R.id.btn_show_img)
        img = findViewById(R.id.img)
        btn_show_img.setOnClickListener({
            if (img.isGone) {
                img.visibility = View.VISIBLE
                btn_show_img.text = "Hide Image"
            } else {
                img.visibility = View.GONE
                btn_show_img.text = "Show Image"
            }
        })
    }

    fun setBackActionArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun getBundleData() {
        val newsData = intent?.getSerializableExtra("obj") as UserResponse
        showData(newsData)
    }

    fun showData(newsData: UserResponse) {
        txt_name.text = newsData?.username
        txt_userid.text = newsData?.id?.toString()
        txt_location.text =
            "Latitude : " + newsData?.address?.geo?.lat + "," + " Logitude :" + newsData?.address?.geo?.lng
        MyUtils.showImage(this, "https://picsum.photos/200", img)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}