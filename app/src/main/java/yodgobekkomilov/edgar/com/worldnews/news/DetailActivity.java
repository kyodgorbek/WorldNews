package yodgobekkomilov.edgar.com.worldnews.news;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
import yodgobekkomilov.edgar.com.worldnews.R;

@SuppressLint("SetJavaScriptEnabled")
public class DetailActivity extends Activity{
    @BindView(R.id.article)
    public WebView article_webview;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        article_webview.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getExtras().getString("urlKey");
        article_webview.setWebViewClient(new WebViewClient());
        article_webview.loadUrl("urlKey");





    }
    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
