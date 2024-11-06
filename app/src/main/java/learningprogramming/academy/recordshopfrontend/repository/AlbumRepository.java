package learningprogramming.academy.recordshopfrontend.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.service.AlbumApiService;
import learningprogramming.academy.recordshopfrontend.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call, @NonNull Response<List<Album>> response) {
                List<Album> albumList = response.body();
                for (Album item: albumList) {
                    Log.d("Get-Album", item.toString());
                }
                mutableLiveData.setValue(albumList);
                List<Album> getAlbums = mutableLiveData.getValue();
                for (Album item: getAlbums) {
                    Log.d("Get-Album2", item.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable throwable) {
                Log.e("HTTP failure", throwable.getMessage());
            }
        });
        return mutableLiveData;
    }

    public void addNewAlbum(Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.addNewAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                                "Album added to Database",
                                Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                                "Unable to add album to Database",
                                Toast.LENGTH_SHORT)
                        .show();
                Log.e("Add album failed", throwable.getMessage());
            }
        });
    }
    public void updateAlbum(long id, Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                                "Album updated",
                                Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                                "Unable to update Album",
                                Toast.LENGTH_SHORT)
                        .show();
                Log.e("Put Request", throwable.getMessage());
            }
        });
    }

    public void deleteAlbum(long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<String> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(application.getApplicationContext(),
                                response.body(),
                                Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                                "Unable to delete Album",
                                Toast.LENGTH_SHORT)
                        .show();
                Log.e("Delete Request", throwable.getMessage());
            }
        });
    }
}
