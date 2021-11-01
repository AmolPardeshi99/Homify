package dev.dominators.homify.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.dominators.homify.R
import dev.dominators.homify.databinding.BottomsheetOtpBinding
import dev.dominators.homify.databinding.BottomsheetRegisterBinding
import dev.dominators.homify.databinding.FragmentRegisterBinding
import dev.dominators.homify.ui.homepage.HomeActivity

class RegisterFrag : Fragment(R.layout.fragment_register) {

    private lateinit var dataBinding:FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding = FragmentRegisterBinding.inflate(layoutInflater)

        val numberDialog = BottomSheetDialog(requireContext())
        val view1 = layoutInflater.inflate(R.layout.bottomsheet_register,null)
        val registerBinding = BottomsheetRegisterBinding.bind(view1)


        numberDialog.setContentView(view1)
        numberDialog.show()

        val otDdialog = BottomSheetDialog(requireContext())
        val view2 = layoutInflater.inflate(R.layout.bottomsheet_otp,null)
        val otpBinding = BottomsheetOtpBinding.bind(view2)

        otDdialog.setContentView(view2)

        registerBinding.verifyOtpRegister.setOnClickListener {
            numberDialog.dismiss()
            otDdialog.show()
        }

        otpBinding.continueGoogleRegister.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}