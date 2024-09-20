package learningprogramming.academy.recordshopfrontend.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.model.AlbumImageModel;
import learningprogramming.academy.recordshopfrontend.repository.AlbumRepository;

public class MainActivityViewModel extends AndroidViewModel {
    AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepository.getMutableLiveData();
    }

    public void addNewAlbum(Album album) {
        albumRepository.addNewAlbum(album);
    }

}
