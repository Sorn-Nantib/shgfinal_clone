package com.example.shg_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.contentInsetStartWithNavigation = 0
        toolbar.setNavigationOnClickListener(){

        }

        viewPager2 = findViewById(R.id.viewPager_ImageSlider)
        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.ads_1))
        sliderItems.add(SliderItem(R.drawable.ads_2))
        sliderItems.add(SliderItem(R.drawable.ads_3))
        viewPager2.adapter = SliderAdapter(sliderItems,viewPager2)


        viewPager2.clipToPadding =false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val indicator  = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager_ImageSlider)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{
            page, position ->
            val r = 1- kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.25f


        }
        viewPager2.setPageTransformer(compositePageTransformer)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview){
            R.id.add -> Toast.makeText(this,"Call clicked",Toast.LENGTH_SHORT).show()
            R.id.notification -> Toast.makeText(this,"Notification",Toast.LENGTH_SHORT).show()
        }
        return false
    }

}
