package dev.dominators.homify.ui.JobCheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivityJobBinding

class JobActivity : AppCompatActivity() {

    private lateinit var binding:ActivityJobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}