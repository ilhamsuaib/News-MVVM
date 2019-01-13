package id.ilhamsuaib.newsmvvm.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.ilhamsuaib.newsmvvm.R
import id.ilhamsuaib.newsmvvm.base.*
import id.ilhamsuaib.newsmvvm.presentation.model.News
import id.ilhamsuaib.newsmvvm.utils.extensions.logD
import id.ilhamsuaib.newsmvvm.utils.extensions.toJson
import id.ilhamsuaib.newsmvvm.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity(), Observer<LiveDataState> {

    private val homeViewModel by viewModel<HomeViewModel>()
    private val newsAdapter = NewsAdapter { news ->
        toast(news.title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupView()

        homeViewModel.liveDataState.observe(this, this)
        homeViewModel.getNews()
    }

    private fun setupView() {
        rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
    }

    override fun onChanged(t: LiveDataState?) {
        when (t) {
            is ShowNews -> showNews(t.news)
            is OnLoading -> showProgress(t.show)
            is OnError -> toast(t.msg)
        }
    }

    private fun showProgress(show: Boolean) {
        progress.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showNews(news: List<News>) {
        logD("showNews : ${news.toJson()}")
        newsAdapter.addItems(news)
    }
}
