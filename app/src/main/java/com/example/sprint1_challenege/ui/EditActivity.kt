package com.example.sprint1_challenege.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.toColorInt
import com.example.sprint1_challenege.R
import com.example.sprint1_challenege.model.Movie
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    companion object {
        const val WATCH_KEY = "WATCHED_KEY"
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_edit)
            var seek = seek_bar_watch
            seek.max = 1

            save_button.setOnClickListener {
                var rating = seek.progress
                var saveMovieIntent = Intent()

                saveMovieIntent.putExtra("MOVIE", watchedMovie())
                saveMovieIntent.putExtra(WATCH_KEY, rating)
                saveMovieIntent.putExtra("movie", createMovie())
                setResult(Activity.RESULT_OK, saveMovieIntent)
                finish()
            }

            delete_button.setOnClickListener {
                var deleteMovieIntent = Intent()
                deleteMovieIntent.putExtra("delete", deleteMovie())
                setResult(Activity.RESULT_CANCELED, deleteMovieIntent)
                finish()
            }

            var bundle: Bundle? = intent.extras
            if (bundle != null) {
                loadMovie(bundle.getSerializable("Movie") as Movie)
            }
        }

        fun loadMovie(movie: Movie) {
            edit_movie.setText(movie.title)
        }

        fun createMovie(): Movie {
            var newMovie = Movie(edit_movie.text.toString())
            return newMovie
        }
        fun watchedMovie(): Movie {
            var watched = Movie(edit_movie.text.toString().plus(55555))
            return watched
    }
    fun deleteMovie(): Movie {
        var delMovie = Movie(edit_movie.text.clear().toString())
        return delMovie
    }
    }
