package com.example.shg_clone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_register_screen.*
import kotlinx.android.synthetic.main.activity_verify_otp_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RegisterScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        verify_btn.setOnClickListener{
            val phone = editTextPhone.text.toString()
            userLogin(phone)
        }

    }

    private fun userLogin(phone: String) {
        val param = DataLoginParam(phone)
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()).baseUrl(
                BASE_URL)
            .build().create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.postLogin(param)
        retrofitData.enqueue(object : Callback<DataLoginRes> {
            override fun onResponse(call: Call<DataLoginRes>, response: Response<DataLoginRes>) {
                Log.e("onSuccess", response.body().toString())
                if(response.isSuccessful) {
                    print(response.body().toString())
                    print(response.message().toString())
                    val phonenumber = Intent(this@RegisterScreen, VerifyOtpScreen::class.java)
                    phonenumber.putExtra("Phone_Number", phone)
                    startActivity(phonenumber)
                }else{
                    val snackbar = Snackbar.make(verify_otp_layout, "Error TESTING  ", Snackbar.LENGTH_LONG)
                    snackbar.show()
                    //error
                }
            }
            override fun onFailure(call: Call<DataLoginRes>, t: Throwable) {
                Log.e("onFail", t.message.toString())
                //error
                val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)

                snackbar.show()
            }


        })
    }
}
