package com.zw.kotlin_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zw.kotlin_android.R
import com.zw.kotlin_android.lombok.User
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 高阶函数写法
        tv_test.run {
            text = System.currentTimeMillis().toString()
        }

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

        btn_Main4Activity_Base_1.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main4Activity_Base_1::class.java)
            startActivity(intent)
        }

        btn_Main4Activity_Base_2.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main4Activity_Base_2::class.java)
            startActivity(intent)
        }

        btn_Main4Activity_Base_3.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main4Activity_Base_3::class.java)
            startActivity(intent)
        }

        btn_Main7Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main7Activity::class.java)
            startActivity(intent)
        }

        btn_Main8Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main8Activity::class.java)
            startActivity(intent)
        }

        btn_companion_object_Main8Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main9Activity::class.java)
            startActivity(intent)
        }

        btn_Main10Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, Main10Activity::class.java)
            startActivity(intent)
        }

        btn_coroutinesActivity.setOnClickListener {
            var intent = Intent(this@HomeActivity, CoroutinesActivity::class.java)
            startActivity(intent)
        }

        btn_协程异步流_Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, 协程异步流_Activity::class.java)
            startActivity(intent)
        }

        btn_练习_Activity.setOnClickListener {
            var intent = Intent(this@HomeActivity, 练习_Activity::class.java)
            startActivity(intent)
        }

        btn_LombokActivity.setOnClickListener {
            var intent = Intent(this@HomeActivity, LombokActivity::class.java)
            startActivity(intent)
        }
    }



}
