package app.training.androidtraininginhouse.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import app.training.androidtraininginhouse.R
import app.training.androidtraininginhouse.databinding.ActivityHomeBinding
import app.training.androidtraininginhouse.fragment.CountryFragment
import app.training.androidtraininginhouse.fragment.HomeFragment
import app.training.androidtraininginhouse.fragment.NewsFragment
import app.training.androidtraininginhouse.fragment.ProfileFragment
import app.training.androidtraininginhouse.fragment.SettingFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.main)

        showFragment(HomeFragment.newInstance("",""))

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    showFragment(HomeFragment.newInstance("",""))
                    true
                }
                R.id.menu_profile -> {
                    showFragment(ProfileFragment.newInstance("",""))
                    true
                }
                R.id.menu_setting -> {
                    showFragment(SettingFragment.newInstance("", ""))
                    true
                }
                R.id.menu_country -> {
                    showFragment(CountryFragment.
                        newInstance("", ""))
                    true
                }
                R.id.menu_news -> {
                    showFragment(NewsFragment.newInstance("",""))
                    true
                }
                else -> false
            }
        }
    }

    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment).commit()
    }
}