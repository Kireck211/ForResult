package iteso.mx.forresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityChangeName : AppCompatActivity(), View.OnClickListener {
    private lateinit var mCancel: Button
    private lateinit var mOk: Button
    private lateinit var mName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_name)

        mCancel = findViewById(R.id.activity_change_name_btn_cancel)
        mOk = findViewById(R.id.activity_change_name_btn_ok)
        mName = findViewById(R.id.activity_change_name_et_name)

        mCancel.setOnClickListener(this)
        mOk.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.activity_change_name_btn_cancel -> {
                setResult(RESULT_CANCELED)
            }
            R.id.activity_change_name_btn_ok -> {
                val intent = Intent()
                intent.putExtra("name", mName.text)
                setResult(RESULT_OK, intent)
            }
        }
        finish()
    }
}
