package learningprogramming.academy.recordshopfrontend.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivity;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;
    private long albumId;

    public UpdateAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitBtnClick(View view) {
        Album updatedAlbum = new Album(
                album.getId(),
                album.getTitle(),
                album.getArtist(),
                album.getReleasedYear(),
                album.getGenre(),
                album.getStock()
        );

        if (Objects.equals(updatedAlbum.getTitle(), "") ||
                Objects.equals(updatedAlbum.getArtist(), "") ||
                Objects.equals(updatedAlbum.getReleasedYear(), "") ||
                Objects.equals(updatedAlbum.getGenre(), "")) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);
            albumId = album.getId();
            viewModel.updateAlbum(albumId, updatedAlbum);
            context.startActivity(i);
        }

    }

    public void onDeleteBtnClicked(View view) {
        Intent i = new Intent(context, MainActivity.class);

        albumId = album.getId();

        viewModel.deleteAlbum(albumId);

        context.startActivity(i);

    }

    public void onBackButtonClick(View view) {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
