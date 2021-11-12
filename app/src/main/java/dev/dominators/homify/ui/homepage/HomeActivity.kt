package dev.dominators.homify.ui.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivityMainBinding
import dev.dominators.homify.ui.training.TestResultFragment
import dev.dominators.homify.ui.training.TrainingTabLayout

class HomeActivity : AppCompatActivity() {

    lateinit var activityMainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {

        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, HomeFragment()).commit()

        activityMainBinding.menuBottom.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.menu_home -> temp = HomeFragment()
                R.id.menu_training -> temp = TrainingFragment()
                R.id.menu_ongoing -> temp = OngoingFragment()
                R.id.menu_money -> temp = MoneyFragment()
            }
            if (temp != null) {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, temp).commit()
            }
            true
        })

    }
}



//R.id.menu_training -> temp = TrainingTabLayout()