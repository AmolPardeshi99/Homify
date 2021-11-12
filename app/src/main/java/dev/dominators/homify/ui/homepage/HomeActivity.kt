package dev.dominators.homify.ui.homepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import dev.dominators.homify.R
import dev.dominators.homify.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var drawerLayout:DrawerLayout

    lateinit var activityMainBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setBottomNavigation()

        drawerLayout = activityMainBinding.drawerLayout
        var navView = activityMainBinding.navView
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
//                R.id.nav_settings ->
//                    replaceFragment(SettingsFragment(), it.title.toString())
//
//                R.id.nav_about ->
//                    replaceFragment(AboutFragment(), it.title.toString())
//
//                R.id.nav_help ->
//                    replaceFragment(HelpFragment(), it.title.toString())
//
//                R.id.nav_coupons -> {
//                    val intent = Intent(this, CouponsActivity::class.java)
//                    startActivity(intent)
//                }

            }
            true

        }

    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()

        // to close the drawer
        drawerLayout.closeDrawers()
        // to set the title on top
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true

        return super.onOptionsItemSelected(item)
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