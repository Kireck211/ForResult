package iteso.mx.forresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityChangePhone : AppCompatActivity(), View.OnClickListener {
    private lateinit var mCancel: Button
    private lateinit var mOk: Button
    private lateinit var mPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_phone)

        mCancel = findViewById(R.id.activity_change_phone_btn_cancel)
        mOk = findViewById(R.id.activity_change_phone_btn_ok)
        mPhone = findViewById(R.id.activity_change_phone_et_name)

        mCancel.setOnClickListener(this)
        mOk.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.activity_change_phone_btn_cancel -> {
                setResult(RESULT_CANCELED)
            }
            R.id.activity_change_phone_btn_ok -> {
                val intent = Intent()
                intent.putExtra("phone", mPhone.text)
                setResult(RESULT_OK, intent)
            }
        }
        finish()
    }
}
