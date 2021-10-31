package dev.dominators.homify.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentRegisterBinding

class RegisterFrag : Fragment(R.layout.fragment_register) {

    private lateinit var dataBinding:FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding = FragmentRegisterBinding.inflate(layoutInflater)

        val dialog = BottomSheetDialog(requireContext())

        val view = layoutInflater.inflate(R.layout.bottomsheet_register,null)

        dialog.setContentView(view)
        dialog.setCancelable(false)
        dialog.show()
    }
}