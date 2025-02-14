package com.example.bookmyshow

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bookmyshow.adapters.BannerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bannerAdapter: BannerAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var slideRunnable: Runnable? = null

    // Sample banners (Make sure these images exist in res/drawable)
    private val bannerImages = listOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3,
        R.drawable.banner4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.bannerViewPager)
        bannerAdapter = BannerAdapter(bannerImages)
        viewPager.adapter = bannerAdapter

        // Enable infinite scrolling effect
        viewPager.offscreenPageLimit = 1
        viewPager.currentItem = 0

        // Start auto-slide
        startAutoSlide()
    }

    private fun startAutoSlide() {
        slideRunnable = object : Runnable {
            override fun run() {
                val nextItem = (viewPager.currentItem + 1) % bannerImages.size
                viewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, 3000) // Slide every 3 seconds
            }
        }
        handler.postDelayed(slideRunnable!!, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        slideRunnable?.let { handler.removeCallbacks(it) } // Remove callbacks properly
    }
}
