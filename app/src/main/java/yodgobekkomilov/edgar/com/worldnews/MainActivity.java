package yodgobekkomilov.edgar.com.worldnews;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import me.riddhimanadib.library.BottomBarHolderActivity;
import me.riddhimanadib.library.NavigationPage;
import yodgobekkomilov.edgar.com.worldnews.news.AllJazeeraFragment;
import yodgobekkomilov.edgar.com.worldnews.news.BBCFragment;
import yodgobekkomilov.edgar.com.worldnews.news.CBCNewsFragment;
import yodgobekkomilov.edgar.com.worldnews.news.CNNFragment;



public class MainActivity extends BottomBarHolderActivity implements AllJazeeraFragment.OnFragmentInteractionListener, BBCFragment.OnFragmentInteractionListener, CNNFragment.OnFragmentInteractionListener, CBCNewsFragment.OnFragmentInteractionListener {


    //    private ApiService apiService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


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