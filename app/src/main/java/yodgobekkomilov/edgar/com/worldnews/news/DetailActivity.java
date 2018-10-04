package yodgobekkomilov.edgar.com.worldnews.news;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import yodgobekkomilov.edgar.com.worldnews.R;

@SuppressLint("SetJavaScriptEnabled")
public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.article)
    public WebView article_webview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbars);

       // setSupportActionBar(toolbar);
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        article_webview.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getExtras().getString("urlKey");
        article_webview.setWebViewClient(new WebViewClient());
        article_webview.loadUrl(url);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
