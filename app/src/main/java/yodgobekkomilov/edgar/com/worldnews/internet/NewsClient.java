package yodgobekkomilov.edgar.com.worldnews.internet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClient {

    public static final String BASE_URL = "https://newsapi.org/";

    /**
     * Get Retrofit Instance
     *
     *
     */





    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static NewsInterface getApiService() {
        return getRetrofitInstance().create(NewsInterface.class);
    }
}

