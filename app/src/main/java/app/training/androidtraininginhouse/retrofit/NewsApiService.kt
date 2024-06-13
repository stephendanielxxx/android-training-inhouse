package app.training.androidtraininginhouse.retrofit


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines/{account}")
    suspend fun getNews(@Query("country") country: String,
                        @Query("apiKey") apiKey: String,
                        @Query("category") category: String): Response<NewsResponse>
}