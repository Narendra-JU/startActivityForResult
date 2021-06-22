package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_EXAMPLE = 0x9345

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = javaClass.simpleName
        buttonMain.setOnClickListener {
            val intent = Intent(applicationContext, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EXAMPLE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (requestCode == REQUEST_CODE_EXAMPLE){
            if (resultCode == Activity.RESULT_OK){
                val result=data?.getStringExtra("EXTRA_DATA")
                Toast.makeText(this, "$result", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "ERRORRRRR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}