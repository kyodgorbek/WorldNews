package yodgobekkomilov.edgar.com.worldnews.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import yodgobekkomilov.edgar.com.worldnews.Pojo.ArticleResponse;
import yodgobekkomilov.edgar.com.worldnews.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private List <ArticleResponse> articleList;

    public NewsAdapter(List<ArticleResponse> articleList) {
        this.articleList = articleList;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.news_item, viewGroup, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        ArticleResponse article = articleList.get(i);
        newsViewHolder.articleAuthor.setText(article.getAuthor());
        newsViewHolder.articleTitle.setText(article.getTitle());
        newsViewHolder.articleDescription.setText(article.getDescription());
        Picasso.get().load(article.getUrlToImage()).into(newsViewHolder.articleImage);


    }


    @Override
    public int getItemCount() {

        return 0;
    }

    public final static class NewsViewHolder extends RecyclerView.ViewHolder {
        // TextView articleAuthor, articleTitle, articleDescription, articleUrl;
        //  ImageView articleImage;
        @BindView(R.id.article_Image)
        ImageView articleImage;
        @BindView(R.id.article_Author)
        TextView articleAuthor;
        @BindView(R.id.article_Title)
        TextView articleTitle;

        @BindView(R.id.article_Description)
        TextView articleDescription;

        @BindView(R.id.article_Url)
        TextView articleUrl;


        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
