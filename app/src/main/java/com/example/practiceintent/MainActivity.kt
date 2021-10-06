package com.example.practiceintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto :${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리내용입력")
            startActivity(myIntent)



        }
        callBtn.setOnClickListener {


            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel :${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)


        }




        dialBtn.setOnClickListener {
//phoneNumEdt 에 입력한 전화번호를 받아서 => 해당번호에 전화연결
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel :${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)



        }

        sendMessageBtn.setOnClickListener{
//         입력한 내용을 변수에 저장

            editNicknameBtn.setOnClickListener {

                val myIntent = Intent(this, EdtNickName::class.java)
                startActivityForResult (myIntent,1005)
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

        if(requestCode == 1005) {

//            추가질문 : 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK){
//                실제 첨부턴 새 닉네임 꺼내서 텍스트뷰에 반영

                val newNickname = data?.getStringExtra("nickname")
                nicknameTxt.text = newNickname
            }
        }


    }
}