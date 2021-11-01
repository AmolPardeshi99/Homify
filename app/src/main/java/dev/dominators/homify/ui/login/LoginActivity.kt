package dev.dominators.homify.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.dominators.homify.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

//        val languageFrag = LanguageFrag()
//        val fragmentManager = supportFragmentManager.beginTransaction()
//        fragmentManager.replace(dataBinding.containerFragmentLogin.id, languageFrag, "languageFragment")
//            .commit()

    }
}