package dev.dominators.homify.ui.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivitySplashScreenBinding
import dev.dominators.homify.ui.Introduction.IntroActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        var flag = CoroutineScope(Dispatchers.Main).async {
            delay(2000)

            val intent = Intent(applicationContext, IntroActivity::class.java)
            startActivity(intent)
        }
    }
}