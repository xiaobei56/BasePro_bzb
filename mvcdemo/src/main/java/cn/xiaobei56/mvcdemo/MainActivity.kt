package cn.xiaobei56.mvcdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.xiaobei56.mvcdemo.const.ConfigConstants
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var file: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun init(){
         file=ConfigConstants(this).requestCatch;
        println(file.toString())
    }
}
