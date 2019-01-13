package id.ilhamsuaib.newsmvvm.presentation.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import id.ilhamsuaib.newsmvvm.base.BaseViewModel
import id.ilhamsuaib.newsmvvm.base.OnError
import id.ilhamsuaib.newsmvvm.base.OnLoading
import id.ilhamsuaib.newsmvvm.base.ShowNews
import id.ilhamsuaib.newsmvvm.data.repository.NewsRepository
import id.ilhamsuaib.newsmvvm.presentation.model.News
import id.ilhamsuaib.newsmvvm.utils.extensions.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by @ilhamsuaib on 12/01/19.
 * github.com/ilhamsuaib
 */

class HomeViewModel(private val repo: NewsRepository) : BaseViewModel() {

    private lateinit var newsList: MutableList<News>

    fun getNews() {
        if (this::newsList.isInitialized) {
            liveDataState.value = ShowNews(newsList)
            return
        }

        newsList = mutableListOf()

        disposables.add(
                repo.getNews()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            liveDataState.value = OnLoading(true)
                        }
                        .doOnComplete {
                            liveDataState.value = OnLoading(false)
                        }
                        .subscribe({
                            this.newsList.addAll(it)
                            liveDataState.value = ShowNews(newsList)
                        }, this::onError)
        )
    }

    private fun onError(t: Throwable) {
        liveDataState.value = OnError(t.localizedMessage)
        t.printStackTrace()
        logE(t.message)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        dispose()
    }
}