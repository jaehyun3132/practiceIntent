package com.example.practiceintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edt_nick_name.*

class EdtNickName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edt_nick_name)


        okBtn.setOnClickListener {

//            입력한 새 닉네임이 뭔지? 새로운 변수로 저장
            val inputNewNickname = newNicknameEdt.text.toString()
//            입력한 데이터를 들고서 메인화면으로 복귀.

            val resultIntent = Intent()
//입력한 닉네임을 달아주기 정도로만 사용하는 Intent다

            resultIntent.putExtra("nickname",inputNewNickname)
            setResult(RESULT_OK,resultIntent)
            finish()






        }
    }
}