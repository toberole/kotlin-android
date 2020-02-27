package com.zw.kotlin_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 设置OnClickListener
        btn_MainActivity.setOnClickListener {
            // 构造Intent
            val intent = Intent(this@HomeActivity, Main1Activity().javaClass)
            startActivity(intent)
        }

        btn_Main2Activity.setOnClickListener {
            val intent = Intent(this@HomeActivity, Main2Activity::class.java)
            startActivity(intent)
        }

        btn_Main3Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main3Activity::class.java)
            startActivity(intent)
        }

        btn_Main4Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main4Activity_Base::class.java)
            startActivity(intent)
        }

        btn_Main5Activity_Class.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main5Activity_Class::class.java)
            startActivity(intent)
        }

        btn_Main6Activity_Lambda.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main6Activity_Lambda::class.java)
            startActivity(intent)
        }


    }
}
