package id.ilhamsuaib.newsmvvm.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

data class NewsResponseModel(
    @field:SerializedName("status")
    val status: String?,
    @field:SerializedName("totalResults")
    val totalResults: Int?,
    @field:SerializedName("articles")
    val articles: List<NewsModel>
)