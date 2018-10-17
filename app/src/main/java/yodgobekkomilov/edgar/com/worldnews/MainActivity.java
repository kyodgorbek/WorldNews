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


import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
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

        Article article = new Article(Parcel.obtain());
        article.setUrl(article.getUrl());
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("urlKey", article);
//        // using the (String name, Parcelable value) overload!
//        startActivity(i);

        NavigationPage page1 = new NavigationPage("Al Jazeera", ContextCompat.getDrawable(this, R.drawable.ic_aljazeera), AllJazeeraFragment.newInstance());
        NavigationPage page2 = new NavigationPage("BBC", ContextCompat.getDrawable(this, R.drawable.bbc_icon), CNNFragment.newInstance());
        NavigationPage page3 = new NavigationPage("CNN", ContextCompat.getDrawable(this, R.drawable.ic_cnn), AllJazeeraFragment.newInstance());
        NavigationPage page4 = new NavigationPage("CBC", ContextCompat.getDrawable(this, R.drawable.ic_cbc), CBCNewsFragment.newInstance());
        //NavigationPage page5 = new NavigationPage("Menu", ContextCompat.getDrawable(this, R.drawable.icon_menu), Menu.newInstance());
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