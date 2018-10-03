package yodgobekkomilov.edgar.com.worldnews.news;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;
import yodgobekkomilov.edgar.com.worldnews.Pojo.ArticleResponse;
import yodgobekkomilov.edgar.com.worldnews.R;
import yodgobekkomilov.edgar.com.worldnews.adapter.NewsAdapter;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsClient;
import yodgobekkomilov.edgar.com.worldnews.internet.NewsInterface;

public class BBCFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    RecyclerView recyclerView;
    NewsAdapter adapter;
    public ArrayList<Article> articleList = new ArrayList();
    public static BBCFragment newInstance() {
        return new BBCFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       final  View rootView = inflater.inflate(R.layout.bbc_fragment, container, false);

        NewsInterface apiService = NewsClient.getApiService();
        Call <ArticleResponse> call = apiService.getBBC();

        call.enqueue(new Callback <ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response <ArticleResponse> response) {

                articleList = new ArrayList(response.body().getArticles());
                recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
                adapter = new NewsAdapter(articleList);
                RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(eLayoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
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
