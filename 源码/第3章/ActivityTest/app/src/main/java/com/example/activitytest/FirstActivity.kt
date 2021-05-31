package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*
import android.R.attr.data
import android.util.Log
import java.util.*


class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", "Task id is $taskId")
        setContentView(R.layout.first_layout)
        button1.setOnClickListener {
    //            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT)
    //                .show()

    //            finish()

    //            val intent = Intent(this, SecondActivity::class.java)

    //            val intent = Intent("com.example.activitytest.ACTION_START")
    //            intent.addCategory("com.example.activitytest.MY_CATEGORY")

    //            val intent = Intent(Intent.ACTION_VIEW)
    //            intent.data = Uri.parse("https://www.baidu.com")

    //            val intent = Intent(Intent.ACTION_DIAL)
    //            intent.data = Uri.parse("tel:10086")

    //            val data = "Hello SecondActivity"
    //            val intent = Intent(this, SecondActivity::class.java)
    //            intent.putExtra("extra_data", data)
    //            startActivity(intent)

    //            val intent = Intent(this, SecondActivity::class.java)
    //            startActivityForResult(intent, 1)

    //            val intent = Intent(this, FirstActivity::class.java)
    //            startActivity(intent)

            // 按下按钮打开第二个Activity
            SecondActivity.actionStart(this, "data1", "data2")
        }
    }


    // 创建菜单栏
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // 相应菜单栏选择
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // 处理不同的菜单栏选项
        when (item?.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    //  https://www.cnblogs.com/yycc/p/11549643.html
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", returnedData)
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }
}
