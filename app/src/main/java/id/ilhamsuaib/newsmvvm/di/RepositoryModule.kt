package id.ilhamsuaib.newsmvvm.di

import id.ilhamsuaib.newsmvvm.data.repository.NewsRepository
import org.koin.dsl.module.module

/**
 * Created by @ilhamsuaib on 12/01/19.
 * github.com/ilhamsuaib
 */

val repositoryModule = module {
    single {
        NewsRepository(get())
    }
}