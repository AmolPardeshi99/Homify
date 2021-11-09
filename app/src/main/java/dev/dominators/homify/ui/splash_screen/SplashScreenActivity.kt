package dev.dominators.homify.ui.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivitySplashScreenBinding
import dev.dominators.homify.ui.Introduction.IntroActivity
import dev.dominators.homify.ui.homepage.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var dataBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        auth = Firebase.auth

        CoroutineScope(Dispatchers.Main).async {
            delay(2000)

            if (auth.currentUser != null) {
                Intent()
                val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashScreenActivity, IntroActivity::class.java)
                startActivity(intent)
            }
            finish()
        }


    }
}