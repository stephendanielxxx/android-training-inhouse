package app.training.androidtraininginhouse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.training.androidtraininginhouse.databinding.ActivityUiControlBinding

class UiControlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUiControlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUiControlBinding.inflate(layoutInflater)
        setContentView(binding.main)

//        val tvHello: TextView = findViewById(R.id.tvHello)
        binding.tvHello.text = "1st Application"
        binding.etUsername.text.toString()
    }
}