package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        lateinit var  EXTRA_DATA:String
    }
    init {
        EXTRA_DATA="EXTRA_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title=javaClass.simpleName
        buttonDetail.setOnClickListener {
            val data= Intent()
            data.putExtra(EXTRA_DATA,"Some Interesting Data")
            setResult(Activity.RESULT_OK,data)
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }
}