package app.training.androidtraininginhouse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.training.androidtraininginhouse.databinding.ItemCountryBinding
import app.training.androidtraininginhouse.databinding.ItemNewsBinding
import app.training.androidtraininginhouse.retrofit.NewsData
import com.bumptech.glide.Glide

class NewsAdapter(
    private val newsList: List<NewsData>,
    private val callback: NewsCallback
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
            init {
                binding.root.setOnClickListener {
                    callback.onNewsClicked(newsList[adapterPosition])
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            val newsData = newsList[position]
            binding.tvAuthor.text = newsData.author
            binding.tvTitle.text = newsData.title

            newsData.urlToImage?.let{
                Glide.with(binding.ivNews.context).load(it)
                    .into(binding.ivNews)
            }

        }
    }

    interface NewsCallback{
        fun onNewsClicked(newsData: NewsData)
    }

}