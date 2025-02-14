package com.example.bookmyshow


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmyshow.R

// Adapter class for the RecyclerView
class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder class to hold the views
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieLikes: TextView = itemView.findViewById(R.id.movieLikes)
    }

    // Inflating the item_movie.xml layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    // Binding data to the views
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieImage.setImageResource(movie.imageRes)
        holder.movieTitle.text = movie.title
        holder.movieLikes.text = movie.likes
    }

    // Returning the total number of items
    override fun getItemCount(): Int = movies.size
}
