package app.training.androidtraininginhouse.retrofit

import retrofit2.Response

class NewsRepository(
    private val newsApiService: NewsApiService) {
    private val API_KEY = "edec38ef3c9f4e93ac8b2f83ffa6a2bd"
    suspend fun getNews(country: String): Response<NewsResponse> {
        return newsApiService.getNews(country, API_KEY)
    }
}