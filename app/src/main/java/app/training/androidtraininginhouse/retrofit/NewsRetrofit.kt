package app.training.androidtraininginhouse.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofit {
    private const val BASE_URL = "https://newsapi.org/v2/"

    private fun getHttpLogging(): HttpLoggingInterceptor{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    private fun getOkHttpClient(): OkHttpClient{
        return OkHttpClient().newBuilder()
            .addInterceptor(getHttpLogging()).build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().client(getOkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiService: NewsApiService =
        getRetrofit().create(NewsApiService::class.java)

}