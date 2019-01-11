package id.ilhamsuaib.newsmvvm

import android.app.Application
import id.ilhamsuaib.newsmvvm.di.networkModule
import org.koin.android.ext.android.startKoin

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(networkModule))
    }
}