package com.example.shg_clone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shg_clone.adapters.AboutUsRecylearAdapter
import kotlinx.android.synthetic.main.activity_about_us.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://shgstaging-v2.z1central.com/"
//const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class AboutUs : AppCompatActivity() {
    var recycler: RecyclerView? = null
    var mAdapter: AboutUsRecylearAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        initView()
        getMyData()
    }
    private fun initView(){
        recycler = findViewById(R.id.rc_about_us)
        recycler?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        mAdapter = AboutUsRecylearAdapter()
        recycler?.adapter = mAdapter
    }
    private fun getMyData() {
      val retrofitBuilder = Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create()).baseUrl(
          BASE_URL)
          .build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<AboutUsX> {

            override fun onResponse(call: Call<AboutUsX>, response: Response<AboutUsX>) {
               // Log.d("MainActivity","onFailure: "+t.message)
                print("not work")
                if(response.isSuccessful){
                    var dataList = response.body()?.data
                    runOnUiThread {
                        mAdapter?.setData(dataList!!)
                    }
                }
            }

            override fun onFailure(call: Call<AboutUsX>, t: Throwable) {
                Log.d("MainActivity","onFailure: "+t.message)
                print("not work")
            }


        })
    }
}
