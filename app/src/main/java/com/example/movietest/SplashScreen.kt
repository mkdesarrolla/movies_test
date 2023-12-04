package com.example.movietest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.movietest.model.ResultCall

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val extras = intent.extras

        if (extras != null){
            var movie: ResultCall = extras!!.getSerializable("movie") as ResultCall
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("movie", movie)
                startActivity(intent)
                finish()
            }, 3000)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }
}
