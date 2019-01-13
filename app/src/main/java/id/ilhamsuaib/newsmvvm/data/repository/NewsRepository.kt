package id.ilhamsuaib.newsmvvm.data.repository

import id.ilhamsuaib.newsmvvm.data.remote.ApiService
import id.ilhamsuaib.newsmvvm.presentation.model.News
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

class NewsRepository(val api: ApiService) {

    fun getNews(): Observable<List<News>> {
        return api.getNews()
            .flatMapIterable {
                it.articles
            }
            .map {
                News(
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt,
                    author = it.author
                )
            }
            .toList()
            .toObservable()
    }
}