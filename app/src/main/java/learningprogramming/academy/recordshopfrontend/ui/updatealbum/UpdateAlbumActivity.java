package learningprogramming.academy.recordshopfrontend.ui.updatealbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import learningprogramming.academy.recordshopfrontend.R;
import learningprogramming.academy.recordshopfrontend.databinding.ActivityUpdateAlbumBinding;
import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandlers handlers;
    private Album album;
    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handlers = new UpdateAlbumClickHandlers(album, this, viewModel);
        binding.setAlbum(album);
        binding.setClickHandlers(handlers);
    }
}