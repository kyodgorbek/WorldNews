package yodgobekkomilov.edgar.com.worldnews.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ParseException;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
import yodgobekkomilov.edgar.com.worldnews.R;
import yodgobekkomilov.edgar.com.worldnews.news.DetailActivity;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    public static final String urlKey = "urlKey";
    public static final String ImageKey = "imageKey";
    private final List<Article> articleList;
    Context context;
    private ClipboardManager myClipboard;
    private ClipData myClip;

    public NewsAdapter(List<Article> articleList) {

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
    public void onBindViewHolder(@NonNull final NewsViewHolder newsViewHolder, final int i) {
        final Article article = articleList.get(i);
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy");

        Date d = new Date();
        try {
            d = input.parse(article.getPublishedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        String formatted = output.format(d);

        newsViewHolder.articleAuthor.setText(article.getAuthor());
        newsViewHolder.articleTitle.setText(article.getTitle());
        newsViewHolder.articleDescription.setText(article.getDescription());
        newsViewHolder.articleDate.setText(formatted);
        //newsViewHolder.articleDate.setText(article.getPublishedAt());
        Picasso.get().load(article.getUrlToImage()).into(newsViewHolder.articleImage);
        newsViewHolder.copy_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                myClipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);


                myClip = ClipData.newPlainText("label", newsViewHolder.articleTitle.getText().toString());
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(v.getContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();

            }
        });
        newsViewHolder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String articleDescription = article.getDescription();
                String articleTitle = article.getTitle();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, articleDescription);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, articleTitle);
                v.getContext().startActivity((Intent.createChooser(sharingIntent, "Share using")));
            }
        });
        newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
//start the activity from the view/context

                intent.putExtra("urlKey", article.getUrl());
                //intent.putExtra("imageKey", article.getUrlToImage());
                view.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {

        return articleList.size();
    }


    public final class NewsViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.article_Date)
        TextView articleDate;
        @BindView(R.id.share_button)
        ImageButton shareButton;
        @BindView(R.id.copy_Button)
        ImageButton copy_Button;


        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (context != null) {
                Typeface typeface = ResourcesCompat.getFont(context, R.font.roboto_black);
                articleTitle.setTypeface(typeface);

            }

        }

    }
}
