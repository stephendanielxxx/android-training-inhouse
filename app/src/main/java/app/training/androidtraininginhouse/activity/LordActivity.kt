package app.training.androidtraininginhouse.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import app.training.androidtraininginhouse.databinding.ActivityLordBinding
import app.training.androidtraininginhouse.viewmodel.LordViewModel

class LordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLordBinding
    private val viewModel: LordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLordBinding.inflate(layoutInflater)
        setContentView(binding.main)

        viewModel.initDatabase(this)

        viewModel.getLords()

        binding.btnSubmit.setOnClickListener {
            val name = binding.etLordName.text.toString()
            val str =  binding.etLordStr.text.toString().toInt()
            val int =  binding.etLordInt.text.toString().toInt()
            viewModel.addLord(name, str, int)
        }

        setObserver()
    }
    private fun setObserver() {
        viewModel.lordLiveData.observe(this){
            Log.i("TAG","LORD DATA $it")
        }
    }
}