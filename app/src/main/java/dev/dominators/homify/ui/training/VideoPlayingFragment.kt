package dev.dominators.homify.ui.training

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dev.dominators.homify.R
import kotlinx.android.synthetic.main.fragment_video_playing.*

class VideoPlayingFragment : YouTubeBaseActivity() {


    val VIDEO_ID = "oI3IqUSmw_k"
    val YOUTUBE_APIKEY = "AIzaSyABGNzUKX7NNoGO1n7s7oNSaRrhsFWXDQI"

    // private lateinit var moviePlayLink: String

    //var mYouTubePlayer: YouTubePlayer? = null
    var currentVolume = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_video_playing)

        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(VIDEO_ID,0f)
                youTubePlayer.setVolume(currentVolume)
            }
        })
    }

}






//override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
//    if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
//        if (currentVolume >= 10) {
//            currentVolume -= 10
//            mYouTubePlayer?.setVolume(currentVolume)
//        }
//    } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
//        if (currentVolume <= 90) {
//            currentVolume += 10
//            mYouTubePlayer?.setVolume(currentVolume)
//        }
//    } else if (keyCode == KeyEvent.KEYCODE_BACK) {
//        finish()
//    }
//    return true
//}