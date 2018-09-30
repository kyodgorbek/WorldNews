package yodgobekkomilov.edgar.com.worldnews.news;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yodgobekkomilov.edgar.com.worldnews.R;

public class RussianTodayFragment extends Fragment {

    private RussianTodayFragment.OnFragmentInteractionListener listener;

    public static RussianTodayFragment newInstance() {
        return new RussianTodayFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.russiantoday_fragment, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RussianTodayFragment.OnFragmentInteractionListener) {
            listener = (RussianTodayFragment.OnFragmentInteractionListener) context;
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
