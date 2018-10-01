package com.example.ramesh.justtail.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.example.ramesh.justtail.MainActivity
import com.example.ramesh.justtail.R


class GFSplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable /*
     * Showing splash screen with a timer. This will be useful when you
     * want to show case your app logo / company
     */

        {
            // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@GFSplashActivity, MainActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }

}
