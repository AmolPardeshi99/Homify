package dev.dominators.homify.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentDetailsBinding
import dev.dominators.homify.ui.homepage.HomeActivity

class DetailsFrag : Fragment(R.layout.fragment_details) {

    private lateinit var binding : FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailsBinding.bind(view)

        binding.nextToHome.setOnClickListener {
            val intent = Intent(context,HomeActivity::class.java)
            startActivity(intent)
        }
    }

}