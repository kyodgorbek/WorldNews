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
import yodgobekkomilov.edgar.com.worldnews.news.CNNFragment;
import yodgobekkomilov.edgar.com.worldnews.news.RussianTodayFragment;


public class MainActivity extends BottomBarHolderActivity implements AllJazeeraFragment.OnFragmentInteractionListener, BBCFragment.OnFragmentInteractionListener, CNNFragment.OnFragmentInteractionListener, RussianTodayFragment.OnFragmentInteractionListener {


    //    private ApiService apiService;


//    @BindView(R.id.coordinator_layout)
//    CoordinatorLayout coordinatorLayout;
//
//    @BindView(R.id.recycler_view)
//    RecyclerView recyclerView;
//
//    @BindView(R.id.txt_empty_notes_view)
//    TextView noNotesView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NavigationPage page1 = new NavigationPage("Home", ContextCompat.getDrawable(this, R.mipmap.ic_launcher), AllJazeeraFragment.newInstance());
        NavigationPage page2 = new NavigationPage("Support", ContextCompat.getDrawable(this, R.mipmap.ic_launcher), CNNFragment.newInstance());
        NavigationPage page3 = new NavigationPage("Billing", ContextCompat.getDrawable(this, R.mipmap.ic_launcher), AllJazeeraFragment.newInstance());
        NavigationPage page4 = new NavigationPage("Profile", ContextCompat.getDrawable(this, R.mipmap.ic_launcher), RussianTodayFragment.newInstance());

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