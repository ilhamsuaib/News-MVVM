package id.ilhamsuaib.newsmvvm.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by @ilhamsuaib on 14/01/19.
 * github.com/ilhamsuaib
 */

open class BaseViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()
    val liveDataState = MutableLiveData<LiveDataState>()

    protected fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}