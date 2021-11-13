package dev.dominators.homify.ui.login

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.dominators.homify.R
import dev.dominators.homify.databinding.BottomsheetOtpBinding
import dev.dominators.homify.databinding.BottomsheetRegisterBinding
import dev.dominators.homify.databinding.FragmentRegisterBinding
import dev.dominators.homify.ui.homepage.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class RegisterFrag : Fragment(R.layout.fragment_register) {

    private lateinit var dataBinding: FragmentRegisterBinding
    lateinit var auth: FirebaseAuth
    lateinit var phoneNum: String
    private lateinit var options: PhoneAuthOptions
    private var verificationCode: String? = null
    lateinit var otpBinding: BottomsheetOtpBinding
    lateinit var registerBinding: BottomsheetRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding = FragmentRegisterBinding.inflate(layoutInflater)

        val numberDialog = BottomSheetDialog(requireContext())
        val view1 = layoutInflater.inflate(R.layout.bottomsheet_register, null)
        registerBinding = BottomsheetRegisterBinding.bind(view1)
        registerBinding.conditionRegister.setText(Html.fromHtml("I agree to the"+"<font color=" + "#FFBC11" + ">" + " Terms and Conditions" + "</font> and"+"<font color=" + "#FFBC11" + ">" + " Privacy Policy" + "</font>."))

        numberDialog.setContentView(view1)
        numberDialog.show()

        val otDdialog = BottomSheetDialog(requireContext())
        val view2 = layoutInflater.inflate(R.layout.bottomsheet_otp, null)
        otpBinding = BottomsheetOtpBinding.bind(view2)

        otDdialog.setContentView(view2)

        registerBinding.verifyOtpRegister.setOnClickListener {
            if(registerBinding.conditionRegister.isChecked) {
                phoneNum = registerBinding.etMobileNo.text.toString()
            sendVerificationCode()
                otpBinding.tvMobileNumberShow.text =
                    " Which has sent to your Mobile Number ${phoneNum}"
                numberDialog.dismiss()
                otDdialog.show()
            }else{
                Toast.makeText(activity?.applicationContext,"Accept terms and condition",Toast.LENGTH_SHORT)
            }
        }

        otpToMove()
        var otp=""
        otpBinding.continueGoogleRegister.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_registerFrag_to_redirectFrag)

            otpBinding.apply {
                otp += et1.text
                otp += et2.text
                otp += et3.text
                otp += et4.text
                otp += et5.text
                otp += et6.text

                if (otp.equals("")){
                    et4.error = "Invalid OTP"
                }else{
                    verifyCode(otp)
                }
            }

            otDdialog.dismiss()
        }



    }



    private val mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                verificationCode = p0

                Toast.makeText(requireContext(),"code sent",Toast.LENGTH_SHORT)

            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val code: String? = p0.smsCode
                if (code != null) {
                    verifyCode(code)
                }
                Toast.makeText(requireContext(),"code sent",Toast.LENGTH_SHORT)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(
                    activity?.applicationContext,
                    "verification failed - ${p0.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    private fun verifyCode(code: String) {
        val credential: PhoneAuthCredential =
            PhoneAuthProvider.getCredential(verificationCode.toString(), code)
        signTheUserByCredentials(credential)
    }

    private fun signTheUserByCredentials(credential: PhoneAuthCredential) {

        val firebaseAuth = FirebaseAuth.getInstance()
        auth.signInWithCredential(credential)
            .addOnCompleteListener(OnCompleteListener<AuthResult>() {
                if (it.isSuccessful) {
                    Toast.makeText(activity?.applicationContext, "Otp verification Successful", Toast.LENGTH_LONG).show()

                    auth.currentUser?.let { it1 ->
                        //addUserDetailsToDatabase(it1.uid)
                    }
//                    val intent = Intent(activity?.applicationContext, HomeActivity::class.java)
//                    startActivity(intent)

                } else {
                    Toast.makeText(activity?.applicationContext, "FAIL", Toast.LENGTH_LONG).show()
                }
            })

    }

//    private fun addUserDetailsToDatabase(uid: String) {
//        val db = Firebase.firebase
//        val user = Users(phoneNumber.toString(), uid)
//        db.collection("users").document(uid).set(user)
//    }

    private fun sendVerificationCode() {
        if (phoneNum != null) {
            options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber("+91$phoneNum")       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(context as Activity)                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }


    private fun otpToMove() {

        otpBinding.apply {

            et1.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (et1.text.toString().length == 1) {
                        et1.clearFocus()
                        et2.requestFocus()
                        et2.setCursorVisible(true)

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {
                    if (et1.text.toString().length == 0) {
                        et1.requestFocus()

                    }
                }
            })

            et2.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (et2.text.toString().length == 1) {
                        et2.clearFocus()
                        et3.requestFocus()
                        et3.setCursorVisible(true)

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {
                    if (et2.text.toString().length == 0) {
                        et2.requestFocus()

                    }
                }
            })

            et3.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (et3.text.toString().length == 1) {
                        et3.clearFocus()
                        et4.requestFocus()
                        et4.setCursorVisible(true)

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {
                    if (et3.text.toString().length == 0) {
                        et3.requestFocus()

                    }
                }
            })

            et4.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (et4.text.toString().length == 1) {
                        et4.clearFocus()
                        et5.requestFocus()
                        et5.setCursorVisible(true)

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {
                    if (et4.text.toString().length == 0) {
                        et4.requestFocus()

                    }
                }
            })

            et5.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (et5.text.toString().length == 1) {
                        et5.clearFocus()
                        et6.requestFocus()
                        et6.setCursorVisible(true)

                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {
                    if (et5.text.toString().length == 0) {
                        et5.requestFocus()

                    }
                }
            })

            et6.addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        if (et6.text.toString().length == 1) {
                            et6.requestFocus()
                            et6.setCursorVisible(true)
                        }
                    }

                    override fun afterTextChanged(s: Editable?) {
                        if (et6.text.toString().length == 0) {
                            et5.requestFocus()
//                        verifyOTP.visibility = View . GONE
                        }
                    }
                })




//            et6.doAfterTextChanged
//        {
//            var otpString: String =
//                otpET1.text.toString() + otpET2.text.toString() + otpET3.text.toString() + otpET4.text.toString() + otpET5.text.toString() + otpET6.text.toString()
//            if (otpString.length > 5) {
//                verifyOTP.visibility = View.VISIBLE
//            }
//        }

        }

    }
}