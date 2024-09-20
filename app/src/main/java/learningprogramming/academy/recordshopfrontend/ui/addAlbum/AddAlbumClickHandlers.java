package learningprogramming.academy.recordshopfrontend.ui.addAlbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivity;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {
    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitBtnClick(View view) {
        if(album.getTitle() == null || album.getArtist() == null ||album.getGenre() == null || album.getReleasedYear() == null) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);

            Album newAlbum = new Album(
                    album.getId(),
                    album.getTitle(),
                    album.getArtist(),
                    album.getReleasedYear(),
                    album.getGenre(),
                    album.getStock()
            );
            viewModel.addNewAlbum(newAlbum);
            context.startActivity(i);
        }
    }

    public void onClickBackBtn(View view) {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
