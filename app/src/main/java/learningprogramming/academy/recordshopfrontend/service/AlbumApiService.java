package learningprogramming.academy.recordshopfrontend.service;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAllAlbums();

    @POST("album")
    Call<Album> addNewAlbum(@Body Album album);

    @PUT("album/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("album/{id}")
    Call<String> deleteAlbum(@Path("id") long id);

}
