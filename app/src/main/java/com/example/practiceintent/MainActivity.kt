package com.example.practiceintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val  REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendMessageBtn.setOnClickListener {
//         입력한 내용을 변수에 저장

            editNicknameBtn.setOnClickListener {

                val myIntent = Intent(this, EdtNickName::class.java)
                startActivityForResult(myIntent,REQUEST_FOR_NICKNAME)
            }
            val inputMessage =messageEdt.text.toString()

            val myIntent = Intent(this,messageActivity ::class.java)

            myIntent.putExtra("message",inputMessage)

            startActivity(myIntent)

        }

        moveToOtherBtn.setOnClickListener {

            //다른화면으로 이동 (OtherActivity)

            val myIntent = Intent(this,OtherActivity::class.java)
          startActivity(myIntent)

        }
    }
}