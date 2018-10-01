package yodgobekkomilov.edgar.com.worldnews.news;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
import yodgobekkomilov.edgar.com.worldnews.R;
import yodgobekkomilov.edgar.com.worldnews.adapter.NewsAdapter;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsClient;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsInterface;

public class AllJazeeraFragment extends Fragment {


    public NewsAdapter adapter;
    public List<Article> articleList;
    RecyclerView recyclerView;

    private AllJazeeraFragment.OnFragmentInteractionListener listener;

    public static AllJazeeraFragment newInstance() {
        return new AllJazeeraFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
         final View rootView = inflater.inflate(R.layout.alljazeera_fragment, container, false);

        NewsInterface apiService = NewsClient.getApiService();
        Call<List<Article>> call = apiService.getAllJazeera();

        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {

                articleList = response.body();
                recyclerView =  (RecyclerView) rootView.findViewById(R.id.recycler_view);
                adapter = new NewsAdapter(articleList);
                RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(eLayoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });

      return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RussianTodayFragment.OnFragmentInteractionListener) {
            listener = (AllJazeeraFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
    }


}
