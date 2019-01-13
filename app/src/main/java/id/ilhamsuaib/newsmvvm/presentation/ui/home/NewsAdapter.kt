package id.ilhamsuaib.newsmvvm.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ilhamsuaib.newsmvvm.R
import id.ilhamsuaib.newsmvvm.presentation.model.News
import kotlinx.android.synthetic.main.item_home_news.view.*

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

class NewsAdapter(private val onItemClick: (news: News) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    private val newsList = mutableListOf<News>()

    fun addItems(news: List<News>) {
        newsList.addAll(news)
        notifyItemRangeChanged(itemCount, newsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_home_news, parent, false)
        return NewsHolder(view)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
        holder.itemView.setOnClickListener {
            onItemClick(news)
        }
    }

    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(news: News) = with(itemView) {
            Glide.with(context)
                    .load(news.urlToImage)
                    .into(imgArticle)

            tvTitle.text = news.title
        }
    }
}