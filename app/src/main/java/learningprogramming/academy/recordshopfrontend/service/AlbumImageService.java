package learningprogramming.academy.recordshopfrontend.service;

import learningprogramming.academy.recordshopfrontend.model.AlbumImageModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumImageService {
    @GET("search")
    Call<AlbumImageModel> searchAlbum(@Query("term") String albumNameWithArtist, @Query("entity") String entity);
}
