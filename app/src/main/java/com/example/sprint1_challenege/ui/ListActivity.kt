package com.example.sprint1_challenege.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sprint1_challenege.R
import com.example.sprint1_challenege.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    var movielist = mutableListOf<Movie>()
    var viewGroup = linear_layout
    companion object {
        const val REQUEST_CODE_EDIT_MOVIE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_movie_button.setOnClickListener {
            var addMovieIntent = Intent(this, EditActivity::class.java)
            startActivityForResult(addMovieIntent, REQUEST_CODE_EDIT_MOVIE)
        }
    }

    fun refreshMovieList() {
        viewGroup.removeAllViews()
        for ((counter,movie) in movielist.withIndex()){
            linear_layout.addView(createTextView(movie, counter))
        }
    }

    override fun onPostResume() {
        refreshMovieList()
        super.onPostResume()
    }

    fun createTextView(movie: Movie, index: Int): TextView {
        var newMovieView = TextView(this)
        newMovieView.textSize = 20f
        newMovieView.id = index
        newMovieView.text = movie.title

        newMovieView.setOnClickListener {
            var movieIntent = Intent(this, EditActivity::class.java)
            movieIntent.putExtra("Movie", movielist[newMovieView.id])
            movielist.removeAt(newMovieView.id)
            startActivityForResult(movieIntent, REQUEST_CODE_EDIT_MOVIE)
        }
        return newMovieView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK) {
            val newMovieResult = data!!.getSerializableExtra("movie") as Movie
            movielist.add(newMovieResult)
        }
    }
}