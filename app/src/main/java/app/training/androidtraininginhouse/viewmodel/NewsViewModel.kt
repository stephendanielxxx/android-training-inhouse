package app.training.androidtraininginhouse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.training.androidtraininginhouse.retrofit.NewsData
import app.training.androidtraininginhouse.retrofit.NewsRepository
import app.training.androidtraininginhouse.retrofit.NewsResponse
import app.training.androidtraininginhouse.retrofit.NewsRetrofit
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(): ViewModel() {
    private lateinit var newsRepository: NewsRepository

    //create live data
    private val newsMutableLiveData = MutableLiveData<List<NewsData>>()
    val newsLiveData = newsMutableLiveData

    fun getNews(country: String, category: String){
        // initialize news repository
        val newsApiService = NewsRetrofit.newsApiService
        newsRepository = NewsRepository(newsApiService)

        // run in coroutines
        viewModelScope.launch {
            val response = newsRepository.getNews(country, category)
            if(response.isSuccessful){
                val body = response.body()
                body?.let {
                    // send data to UI
                    newsMutableLiveData.value = it.articles
                }
            }
        }
    }
}