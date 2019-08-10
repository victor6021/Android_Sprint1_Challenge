package com.example.sprint1_challenege.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.sprint1_challenege.R
import com.example.sprint1_challenege.model.Movie
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    var movielist = mutableListOf<Movie>()

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
        linear_layout.removeAllViews()
        for ((counter, movie) in movielist.withIndex()) {
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
        var newMovieView1 = TextView(this)
        newMovieView1.textSize = 40f
        newMovieView1.id = index
        newMovieView1.text = movie.title.capitalize()

        newMovieView.setOnClickListener {
            var movieIntent = Intent(this, EditActivity::class.java)
            movieIntent.putExtra("Movie", movielist[newMovieView.id])
            movielist.removeAt(newMovieView.id)
            startActivityForResult(movieIntent, REQUEST_CODE_EDIT_MOVIE)
            if (seek_bar_watch.progress == 0) {
                newMovieView
            }
            if (seek_bar_watch.progress == 1) {
                movieIntent.putExtra("Movie", movielist[newMovieView1.id])
                movielist.removeAt(newMovieView1.id)
                startActivityForResult(movieIntent, REQUEST_CODE_EDIT_MOVIE)
                newMovieView1
            }
        }
        return newMovieView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_EDIT_MOVIE && resultCode == Activity.RESULT_OK) {
            var newMovieResult = data!!.getSerializableExtra("movie") as Movie
            movielist.add(newMovieResult)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("List_onStart", movielist.toString())

    }

    override fun onResume() {
        super.onResume()
        Log.i("List_onResume", movielist.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.i("List_onPause", movielist.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.i("List_onStop", movielist.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("List_onDestroy", movielist.toString())
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("List_onRestart", movielist.toString())
    }
}
