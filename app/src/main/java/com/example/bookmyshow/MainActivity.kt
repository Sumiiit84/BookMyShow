package com.example.bookmyshow

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.HorizontalScrollView
import android.widget.SeekBar
import androidx.viewpager2.widget.ViewPager2



class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private val imageList = listOf(
        R.drawable.ad1,
        R.drawable.ad2,
        R.drawable.ad3,
        R.drawable.ad4
    )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        viewPager = findViewById(R.id.viewPager)
        val adapter = ImageAdapter(this, imageList)
        viewPager.adapter = adapter
    }


}












