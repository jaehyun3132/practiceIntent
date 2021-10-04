package com.example.practiceintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val  REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?)  {
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


//돌아온 이유가 닉네임을 받으러 다녀온게 맞는지>

        if(requestCode == REQUEST_FOR_NICKNAME) {

//            추가질문 : 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK){
//                실제 첨부턴 새 닉네임 꺼내서 텍스트뷰에 반영

                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname
            }
        }


    }
}