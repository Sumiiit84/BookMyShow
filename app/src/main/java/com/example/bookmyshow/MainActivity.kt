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
import com.example.bookmyshow.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private val imageList = listOf(
        R.drawable.ad1,
        R.drawable.ad2,
        R.drawable.ad3,
        R.drawable.ad4
    )

    private lateinit var binding: ActivityMainBinding
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
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val movies = listOf(
            Movie("Chhaava", R.drawable.sample_movie, "334.1K likes"),
            Movie("Captain America: Brave New World", R.drawable.captain_america, "132.2K likes"),
            Movie("Sky Force", R.drawable.sky_force, "8.9 ★ 53K votes"),
            Movie("Loveyapa", R.drawable.loveya, "8 ★ 3.5K votes"),
            Movie("Deva", R.drawable.deva, "7.5 ★ 18.1k votes")
        )
        recyclerView.adapter = MovieAdapter(movies)





        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_movies -> {
                    Toast.makeText(this, "Movies Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_live_events -> {
                    Toast.makeText(this, "Live Events Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }

        }

    }
}












