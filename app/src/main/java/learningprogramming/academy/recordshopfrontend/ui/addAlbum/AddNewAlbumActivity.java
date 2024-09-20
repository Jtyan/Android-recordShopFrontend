package learningprogramming.academy.recordshopfrontend.ui.addAlbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import learningprogramming.academy.recordshopfrontend.R;
import learningprogramming.academy.recordshopfrontend.databinding.ActivityAddNewAlbumBinding;
import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding binding;
    private AddAlbumClickHandlers handlers;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addNewAlbum), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        album = new Album();

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
        handlers = new AddAlbumClickHandlers(album, this, viewModel);
        binding.setAlbum(album);
        binding.setClickHandlers(handlers);

    }


}