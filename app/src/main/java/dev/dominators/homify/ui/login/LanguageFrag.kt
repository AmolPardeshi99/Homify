package dev.dominators.homify.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentLanguageBinding
import dev.dominators.homify.databinding.LangDialogBinding


class LanguageFrag : Fragment(R.layout.fragment_language) {

    private lateinit var dataBinding:FragmentLanguageBinding
    private lateinit var langBinding: LangDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding = FragmentLanguageBinding.inflate(layoutInflater)

        val dialog = BottomSheetDialog(requireContext())

        var view1 = layoutInflater.inflate(R.layout.lang_dialog,null)
        langBinding= LangDialogBinding.bind(view1)
        langBinding.nextToRegister.setOnClickListener {
            val intent = Intent(requireContext(),RegisterFrag::class.java)
            startActivity(intent)
        }
        dialog.setContentView(view1)
        dialog.setCancelable(false)
        dialog.show()


    }

}