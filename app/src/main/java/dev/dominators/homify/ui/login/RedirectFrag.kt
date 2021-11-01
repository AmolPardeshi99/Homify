package dev.dominators.homify.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentRedirectBinding
import dev.dominators.homify.ui.homepage.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class RedirectFrag : Fragment(R.layout.fragment_redirect) {

    private lateinit var fragBinding: FragmentRedirectBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragBinding = FragmentRedirectBinding.bind(view)

        val str1 = "Automatically redirected to next page in"
        var str2 = "<font color=" + "#F72585" + ">" + "3" + "</font>"
        val str3 = "Seconds..."

        fragBinding.redirectNumber.setText(Html.fromHtml(str1 + str2 + str3))

        var flag0 = CoroutineScope(Dispatchers.Main).async {
            delay(1000)
            str2 = "<font color=" + "#F72585" + ">" + "2" + "</font>"
            fragBinding.redirectNumber.setText(Html.fromHtml(str1 + str2 + str3))
        }
        var flag1 = CoroutineScope(Dispatchers.Main).async {
            delay(1000)
            str2 = "<font color=" + "#F72585" + ">" + "1" + "</font>"
            fragBinding.redirectNumber.setText(Html.fromHtml(str1 + str2 + str3))
        }
        var flag3 = CoroutineScope(Dispatchers.Main).async {
            delay(1000)
            str2 = "<font color=" + "#F72585" + ">" + "0" + "</font>"
            fragBinding.redirectNumber.setText(Html.fromHtml(str1 + str2 + str3))

            Navigation.findNavController(view).navigate(R.id.action_redirectFrag_to_detailsFrag)
        }




    }

}