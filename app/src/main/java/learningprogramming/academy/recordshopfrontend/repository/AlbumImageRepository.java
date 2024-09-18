package learningprogramming.academy.recordshopfrontend.repository;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.R;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.model.AlbumImageModel;
import learningprogramming.academy.recordshopfrontend.service.RetrofitInstance;
import learningprogramming.academy.recordshopfrontend.service.AlbumImageService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumImageRepository {
    private AlbumImageService albumImageService;

    public void fetchAlbumImage(String albumName, ImageView imageView) {
        albumImageService = RetrofitInstance.getITunesService();
        Call<AlbumImageModel> call = albumImageService.searchAlbum(albumName, "album");

        call.enqueue(new Callback<AlbumImageModel>() {
            @Override
            public void onResponse(@NonNull Call<AlbumImageModel> call, @NonNull Response<AlbumImageModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AlbumImageModel.AlbumResult> albums = response.body().getResults();
                    if (!albums.isEmpty()) {
                        String artworkUrl = albums.get(0).getArtworkUrl();

                        Glide.with(imageView.getContext())
                                .load(artworkUrl)
                                .placeholder(R.drawable.ic_launcher_background)
                                .into(imageView);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<AlbumImageModel> call, @NonNull Throwable t) {
                Log.e("iTunes HTTP Failure ", t.getMessage());
            }
        });
    }
}
