package id.ilhamsuaib.newsmvvm.base

import id.ilhamsuaib.newsmvvm.presentation.model.News

/**
 * Created by @ilhamsuaib on 12/01/19.
 * github.com/ilhamsuaib
 */

sealed class LiveDataState

data class ShowNews(val news: List<News>) : LiveDataState()
data class OnLoading(val show: Boolean) : LiveDataState()
data class OnError(val msg: String) : LiveDataState()