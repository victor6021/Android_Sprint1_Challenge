package com.example.sprint1_challenege.utils

import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.sprint1_challenege.R
import kotlinx.android.synthetic.main.activity_edit.*

class SeekBar: AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private var movieView: EditText? = null
    private var seekBarView: SeekBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        this.seek_bar_watch!!.setOnSeekBarChangeListener(this)

        movieView = this.edit_movie
        seekBarView = this.seek_bar_watch
        seekBarView!!.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                               fromUser: Boolean) {
        if (seekBarView = 0){

        }
    }
}