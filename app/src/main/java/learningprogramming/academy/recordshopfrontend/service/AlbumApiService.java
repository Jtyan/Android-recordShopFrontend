package learningprogramming.academy.recordshopfrontend.service;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAllAlbums();
}
