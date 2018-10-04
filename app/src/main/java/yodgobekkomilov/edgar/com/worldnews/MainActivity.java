package yodgobekkomilov.edgar.com.worldnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.library.BottomBarHolderActivity;
import me.riddhimanadib.library.NavigationPage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
import yodgobekkomilov.edgar.com.worldnews.Pojo.ArticleResponse;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsClient;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsInterface;
import yodgobekkomilov.edgar.com.worldnews.news.AllJazeeraFragment;
import yodgobekkomilov.edgar.com.worldnews.news.BBCFragment;
import yodgobekkomilov.edgar.com.worldnews.news.CBCNewsFragment;
import yodgobekkomilov.edgar.com.worldnews.news.CNNFragment;
import yodgobekkomilov.edgar.com.worldnews.news.DetailActivity;


public class MainActivity extends BottomBarHolderActivity implements AllJazeeraFragment.OnFragmentInteractionListener, BBCFragment.OnFragmentInteractionListener, CNNFragment.OnFragmentInteractionListener, CBCNewsFragment.OnFragmentInteractionListener {


    //    private ApiService apiService;
    public static final String url_key = "urlKey";
    public ArrayList<Article> articleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        NewsInterface newsInterface = NewsClient.getApiService();
        Call<ArticleResponse> call = newsInterface.getCNN();
        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                articleList = new ArrayList((response.body().getArticles()));
            String articleUrl =  articleList.get(6).getUrl();
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra("urlKey", articleUrl);
            startActivity(i);

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });

//        Article article = new Article(Parcel.obtain());
//        article.setUrl(article.getUrl());
//        Intent i = new Intent(this, DetailActivity.class);
//        i.putExtra("myDataKey", article);
//        // using the (String name, Parcelable value) overload!
//        startActivity(i);

        NavigationPage page1 = new NavigationPage("AllJazeera", ContextCompat.getDrawable(this, R.drawable.alljazeera), AllJazeeraFragment.newInstance());
        NavigationPage page2 = new NavigationPage("Support", ContextCompat.getDrawable(this, R.drawable.bbc_icon), CNNFragment.newInstance());
        NavigationPage page3 = new NavigationPage("Billing", ContextCompat.getDrawable(this, R.drawable.cnn_icon), AllJazeeraFragment.newInstance());
        NavigationPage page4 = new NavigationPage("Profile", ContextCompat.getDrawable(this, R.drawable.cbc_icon), CBCNewsFragment.newInstance());

        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(page1);
        navigationPages.add(page2);
        navigationPages.add(page3);
        navigationPages.add(page4);

        super.setupBottomBarHolderActivity(navigationPages);
    }


    public void onClicked() {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
    }

}