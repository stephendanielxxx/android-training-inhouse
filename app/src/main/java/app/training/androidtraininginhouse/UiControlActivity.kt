package app.training.androidtraininginhouse

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.training.androidtraininginhouse.databinding.ActivityUiControlBinding
import app.training.androidtraininginhouse.fragment.HomeFragment
import app.training.androidtraininginhouse.local.SharedPreferenceUtil
import com.google.android.material.snackbar.Snackbar

class UiControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUiControlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUiControlBinding.inflate(layoutInflater)
        setContentView(binding.main)

//        val tvHello: TextView = findViewById(R.id.tvHello)
        binding.tvHello.text = "1st Application"

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()

            if(username.isEmpty() || username.isBlank()){
                Toast.makeText(applicationContext, "Username must be filled", Toast.LENGTH_SHORT).show()
            }else{
                SharedPreferenceUtil.saveStringData(applicationContext, "username", username)

                Snackbar.make(
                    it, "Login Success",
                    Snackbar.LENGTH_SHORT
                ).setAction("OK") {
                    Toast.makeText(
                        this, "Retry is clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }.show()
            }
        }

        binding.ivImage.setImageResource(
            R.drawable.images
        )
        binding.ivImage.visibility = View.VISIBLE
        // image click action
        binding.ivImage.setOnClickListener {
            Toast.makeText(
                this, "Image clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.cbAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    this, "Agree",
                    Toast.LENGTH_SHORT
                ).show()
                buttonView.text = "I Agree !!"
            } else {
                Toast.makeText(
                    this, "Disagree",
                    Toast.LENGTH_SHORT
                ).show()
                buttonView.text = "I Disagree !!"
            }
        }

        binding.rgGender
            .setOnCheckedChangeListener { group, checkedId ->
                var gender = ""
                when (checkedId) {
                    R.id.rbMale -> {
                        gender = "male"
                    }

                    R.id.rbFemale -> {
                        gender = "female"
                    }
                }
                binding.tvGender.text = "Selected gender $gender"
            }

        binding.swDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.main.setBackgroundColor(getColor(R.color.black))
            } else {
                binding.main.setBackgroundColor(getColor(R.color.white))
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, HomeFragment())
            .commit()
    }
}