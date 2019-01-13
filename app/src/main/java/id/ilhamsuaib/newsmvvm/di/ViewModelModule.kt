package id.ilhamsuaib.newsmvvm.di

import id.ilhamsuaib.newsmvvm.presentation.ui.home.HomeViewModel
import org.koin.dsl.module.module

/**
 * Created by @ilhamsuaib on 12/01/19.
 * github.com/ilhamsuaib
 */

val viewModelModule = module {
    single {
        HomeViewModel(get())
    }
}