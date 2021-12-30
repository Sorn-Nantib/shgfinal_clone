package com.example.shg_clone


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_verify_otp_screen.*


class VerifyOtpScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val i = Intent(this, Main2Activity::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val value = intent.getStringExtra("Phone_Number")
        tv_phone.setText("(+855 $value)")

        et_1.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (et_1.text.length == 1) //size as per your requirement
                {
                    et_2.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })
        et_2.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (et_2.text.length == 1) //size as per your requirement
                {
                    et_3.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

                // TODO Auto-generated method stub
            }
        })

        et_3.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub
                if (et_3.text.length == 1) //size as per your requirement
                {
                    et_4.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        et_4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                if (et_1.text.toString() == "1" && et_2.text.toString() == "2" && et_3.text.toString() == "3" && et_4.text.toString() == "4") {
                    startActivity(i)
                    finish()
                } else {
                    val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)
                    
                    snackbar.show()
                }
            }
        })


    }
    private fun createSnackbar(){
        val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)
        snackbar.show()
    }
}
