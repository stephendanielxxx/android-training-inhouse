package app.training.androidtraininginhouse.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.training.androidtraininginhouse.R
import app.training.androidtraininginhouse.databinding.ActivityNewsDetailBinding
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.main)

        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val image = intent.getStringExtra("image")
        val date = intent.getStringExtra("date")
        val author = intent.getStringExtra("author")

        Glide.with(applicationContext).load(image).into(binding.ivNews)
        binding.tvTitle.text = title
        binding.tvAuthor.text = author
        binding.tvContent.text = content
        binding.tvDate.text = date
    }
}