package app.training.androidtraininginhouse.retrofit

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsData>
)

data class NewsData(
    val source: SourceNews,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class SourceNews(
    val id: String?,
    val name: String
)

