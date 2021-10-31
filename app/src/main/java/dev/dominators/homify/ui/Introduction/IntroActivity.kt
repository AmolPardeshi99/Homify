package dev.dominators.homify.ui.Introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivityIntroBinding
import dev.dominators.homify.ui.MainActivity

class IntroActivity : AppCompatActivity() {

    private lateinit var dataBinding:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        dataBinding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        dataBinding.dotsIndicator.setViewPager2(dataBinding.viewPager)

        dataBinding.skipIntro.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}