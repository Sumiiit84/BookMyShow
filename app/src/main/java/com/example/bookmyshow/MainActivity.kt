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
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmyshow.R
import androidx.recyclerview.widget.LinearLayoutManager




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


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val movies = listOf(
            Movie("Chhaava", R.drawable.sample_movie, "334.1K likes"),
            Movie("Captain America: Brave New World", R.drawable.captain_america, "132.2K likes"),
            Movie("Sky Force", R.drawable.sky_force, "8.9 ★ 53K votes")
        )

        recyclerView.adapter = MovieAdapter(movies)
    }


}












