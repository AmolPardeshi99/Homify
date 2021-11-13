package dev.dominators.homify.ui.splash_screen

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.dominators.homify.databinding.ActivitySplashScreenBinding
import dev.dominators.homify.ui.Introduction.IntroActivity
import dev.dominators.homify.ui.homepage.HomeActivity
import android.net.Uri
import android.view.WindowManager
import dev.dominators.homify.R


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var dataBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.BLACK

        dataBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        auth = Firebase.auth

        var videoView = dataBinding.videoView

        videoView.setMediaController(MediaController(this))

        val path: Uri = Uri.parse("android:resource://dev.dominators.homify/"+ R.raw.splash_screen)
        videoView.setVideoURI(path)

        videoView.setOnPreparedListener { mp -> mp.start() }
        videoView.setOnCompletionListener {
            if (auth.currentUser != null) {
                Intent()
                val intent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this@SplashScreenActivity, IntroActivity::class.java)
                startActivity(intent)
            }
        }



    }
}