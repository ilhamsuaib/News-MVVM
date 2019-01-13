package id.ilhamsuaib.newsmvvm.data.remote

import id.ilhamsuaib.newsmvvm.data.remote.model.NewsResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

interface ApiService {

    @GET("top-headlines?country=id")
    fun getNews(): Observable<NewsResponseModel>
}