package com.example.practiceintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_message.*

class messageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

//        첨부된 데이터를 덱스트뷰에 저장
        val intentMessage = intent.getStringExtra("message")

        reciveMessageTxt.text = intentMessage
    }
}