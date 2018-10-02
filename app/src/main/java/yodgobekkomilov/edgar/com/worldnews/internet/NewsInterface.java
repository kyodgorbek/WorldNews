package yodgobekkomilov.edgar.com.worldnews.internet;



import retrofit2.Call;
import retrofit2.http.GET;

import yodgobekkomilov.edgar.com.worldnews.Pojo.ArticleResponse;


public interface NewsInterface {


    @GET("v2/top-headlines?sources=al-jazeera-english&apiKey=a5cc70bd52c9436785557878f4aa49e1")
    Call <ArticleResponse> getAllJazeera();

    @GET("v2/top-headlines?sources=cbc-news&apiKey=a5cc70bd52c9436785557878f4aa49e1")
    Call <ArticleResponse> getCbC();

    @GET("v2/top-headlines?sources=bbc-news&apiKey=a5cc70bd52c9436785557878f4aa49e1")
    Call <ArticleResponse> getBBC();

    @GET("v2/top-headlines?sources=cnn&apiKey=a5cc70bd52c9436785557878f4aa49e1")
    Call <ArticleResponse> getCNN();


}

