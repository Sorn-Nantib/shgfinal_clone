package com.example.shg_clone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.viewPager_ImageSlider
import kotlinx.android.synthetic.main.app_bar_drawer_main.*
import kotlinx.android.synthetic.main.content_home_dashboard_fragment.*
import me.relex.circleindicator.CircleIndicator3

class Main2Activity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    //new
   private val sliderHandler = Handler()

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_main)
        setSupportActionBar(toolbar2)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment_content_drawer_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


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
        //new
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable,3000)
            }
        })
        //
        val values =
            Intent(this, RegisterScreen::class.java)
        navView.apply {
            setNavigationItemSelectedListener {
                val id = it.itemId
                if (id == R.id.nav_home) {
                    val navController = findNavController(R.id.nav_host_fragment_content_drawer_main)
                    navController.navigate(R.id.go_to_load)
                    // DO your stuff
                    Toast.makeText(this@Main2Activity, "You ar clicking home", Toast.LENGTH_SHORT).show()
                }else if(id == R.id.log_out){
                   startActivity(values)
                }
                else{
                    Toast.makeText(this@Main2Activity, "You are click other button", Toast.LENGTH_SHORT).show()
                }
                drawerLayout.closeDrawers()
                true
            }
        }

        btn_about_us.setOnClickListener{
            startActivity(Intent(this,AboutUs::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_drawer_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview){
            R.id.add -> Toast.makeText(this,"Call clicked", Toast.LENGTH_SHORT).show()
            R.id.notification -> Toast.makeText(this,"Notification", Toast.LENGTH_SHORT).show()
        }
        return false
    }
    //new
    private val sliderRunnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
}
