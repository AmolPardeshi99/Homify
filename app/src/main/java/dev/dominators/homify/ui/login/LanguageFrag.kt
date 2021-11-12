package dev.dominators.homify.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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

        dialog.setContentView(view1)
        dialog.setCancelable(false)
        dialog.show()

        langBinding.nextToRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_languageFrag_to_registerFrag)
            dialog.dismiss()
        }

    }

}