package iteso.mx.forresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mChangeName: Button
    private lateinit var mChangePhone: Button
    private lateinit var mName: TextView
    private lateinit var mPhone: TextView

    companion object {
        const val CHANGE_NAME = 1000
        const val CHANGE_PHONE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mChangeName = findViewById(R.id.activity_main_btn_name)
        mChangePhone = findViewById(R.id.activity_main_btn_phone)
        mName = findViewById(R.id.activity_main_tv_name)
        mPhone = findViewById(R.id.activity_main_tv_phone)

        mChangeName.setOnClickListener(this)
        mChangePhone.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.activity_main_btn_name -> {
                val intent = Intent(this, ActivityChangeName::class.java)
                startActivityForResult(intent, CHANGE_NAME)
            }
            R.id.activity_main_btn_phone -> {
                val intent = Intent(this, ActivityChangePhone::class.java)
                startActivityForResult(intent, CHANGE_PHONE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            CHANGE_NAME -> {
                when(resultCode) {
                    RESULT_OK -> mName.text = data?.extras?.get("name").toString() ?: ""
                    RESULT_CANCELED -> Log.d("TAG", "CANCELED")
                }
            }
            CHANGE_PHONE -> {
                when(resultCode) {
                    RESULT_OK -> mPhone.text = data?.extras?.get("phone").toString() ?: ""
                    RESULT_CANCELED -> Log.d("TAG", "CANCELED")
                }
            }
        }
    }
}
