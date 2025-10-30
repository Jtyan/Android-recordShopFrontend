package learningprogramming.academy.recordshopfrontend.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.repository.AlbumRepository;
import learningprogramming.academy.recordshopfrontend.ui.addAlbum.AlbumAddCallBack;
import learningprogramming.academy.recordshopfrontend.ui.updatealbum.AlbumUpdateCallback;

public class MainActivityViewModel extends AndroidViewModel {
    private final AlbumRepository albumRepository;
    private final LiveData<List<Album>> allAlbums;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
        this.allAlbums = albumRepository.getAlbumsLiveData();
    }

    public LiveData<List<Album>> getAllAlbums() {
        return allAlbums;
    }

    public void refreshAlbums() {
        albumRepository.fetchAlbums();
    }

    public void addNewAlbum(Album album, AlbumAddCallBack callback) {
        albumRepository.addNewAlbum(album, callback);
    }

    public void updateAlbum(long id, Album album, AlbumUpdateCallback callback) {
        albumRepository.updateAlbum(id, album, callback);
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteAlbum(id);
    }
}
