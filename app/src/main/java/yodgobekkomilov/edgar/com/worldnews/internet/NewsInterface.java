package yodgobekkomilov.edgar.com.worldnews.internet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import yodgobekkomilov.edgar.com.worldnews.Pojo.Article;

public interface NewsInterface {



        @GET("v2/top-headlines?sources=al-jazeera-english&apiKey=a5cc70bd52c9436785557878f4aa49e1")
        Call<List<Article>> getAllJazeera();


    }

