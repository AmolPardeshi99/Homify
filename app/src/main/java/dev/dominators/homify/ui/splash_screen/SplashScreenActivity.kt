package dev.dominators.homify.ui.splash_screen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import dev.dominators.homify.ui.homepage.HomeActivity
import android.net.Uri
import android.util.Log
import android.view.WindowManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.dominators.homify.R
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        window.statusBarColor = Color.BLACK
        setContentView(R.layout.activity_splash_screen)

        val path = "android.resource://dev.dominators.homify/" + R.raw.splash_screen

        val uri = Uri.parse(path)
        videoView.setVideoURI(uri)

        videoView.setOnPreparedListener { mp -> mp.start() }

        videoView.setOnCompletionListener {
            Log.d("amol", auth.currentUser.toString())
            if (auth.currentUser != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
