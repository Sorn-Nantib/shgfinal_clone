package com.example.shg_clone


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.chaos.view.PinView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_verify_otp_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class VerifyOtpScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val i = Intent(this, Main2Activity::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val phonenumber = intent.getStringExtra("Phone_Number")
        tv_phone.setText("(+855 $phonenumber)")






        fun userLogin(phone: String,verify_code:Int) {
            val param = DataOTPParam(phone,verify_code)
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(
                    BASE_URL)
                .build().create(ApiInterface::class.java)
            val retrofitData = retrofitBuilder.postLogin(param)
            retrofitData.enqueue(object : Callback<DataOTP> {
                override fun onResponse(call: Call<DataOTP>, response: Response<DataOTP>) {
                    Log.e("onSuccess", response.body().toString())
                    if(response.isSuccessful) {
                        print(response.body().toString())
                        print(response.message().toString())
                        val phonenumber = Intent(this@VerifyOtpScreen, MainActivity::class.java)
                        phonenumber.putExtra("Phone_Number", phone)
                        startActivity(phonenumber)
                    }else{
                        val snackbar = Snackbar.make(verify_otp_layout, "Error TESTING  ", Snackbar.LENGTH_LONG)
                        snackbar.show()
                        //error
                    }
                }
                override fun onFailure(call: Call<DataOTP>, t: Throwable) {
                    Log.e("onFail", t.message.toString())
                    //error
                    val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)

                    snackbar.show()
                }


            })
        }
//
//        et_1.addTextChangedListener(object : TextWatcher {
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                // TODO Auto-generated method stub
//                if (et_1.text.length == 1) //size as per your requirement
//                {
//                    et_2.requestFocus()
//                }
//            }
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//                // TODO Auto-generated method stub
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                // TODO Auto-generated method stub
//            }
//        })
//        et_2.addTextChangedListener(object : TextWatcher {
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                // TODO Auto-generated method stub
//                if (et_2.text.length == 1) //size as per your requirement
//                {
//                    et_3.requestFocus()
//                }
//            }
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//                // TODO Auto-generated method stub
//            }
//
//            override fun afterTextChanged(s: Editable) {
//
//                // TODO Auto-generated method stub
//            }
//        })
//
//        et_3.addTextChangedListener(object : TextWatcher {
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                // TODO Auto-generated method stub
//                if (et_3.text.length == 1) //size as per your requirement
//                {
//                    et_4.requestFocus()
//                }
//            }
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//                // TODO Auto-generated method stub
//            }
//
//            override fun afterTextChanged(s: Editable) {
//
//            }
//        })
//        et_4.addTextChangedListener(object : TextWatcher {
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                // TODO Auto-generated method stub
//
//            }
//
//            override fun beforeTextChanged(
//                s: CharSequence, start: Int,
//                count: Int, after: Int
//            ) {
//                // TODO Auto-generated method stub
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                    val
//                if (et_1.text.toString() == "1" && et_2.text.toString() == "2" && et_3.text.toString() == "3" && et_4.text.toString() == "4") {
//                    startActivity(i)
//                    finish()
//                } else {
//                    val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)
//
//                    snackbar.show()
//                }
//             }
//        })

//        val apiInterface = ApiInterface.create().getCountry()
//        apiInterface.enqueue( object : Callback<List<data>>{
//            override fun onResponse(call: Call<List<data>>?, response: Response<List<data>>?) {
//                if(response?.body() != null){
//                    val adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_item,response.body()!!)
//
//                    binding.spCountry.adapter=adapter //spCountry is a spinner
//                }
//            }
//            override fun onFailure(call: Call<List<data>>?, t: Throwable?) {}
//        })
    }



    private fun createSnackbar(){
        val snackbar = Snackbar.make(verify_otp_layout, "Simple Snackbar ", Snackbar.LENGTH_LONG)
        snackbar.show()
    }
}

private fun Any.enqueue(callback: Callback<DataOTP>) {

}

