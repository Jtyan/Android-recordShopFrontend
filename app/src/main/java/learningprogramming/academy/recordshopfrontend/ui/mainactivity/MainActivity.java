package learningprogramming.academy.recordshopfrontend.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learningprogramming.academy.recordshopfrontend.R;
import learningprogramming.academy.recordshopfrontend.databinding.ActivityMainBinding;
import learningprogramming.academy.recordshopfrontend.model.Album;
import learningprogramming.academy.recordshopfrontend.ui.addAlbum.AddNewAlbumActivity;
import learningprogramming.academy.recordshopfrontend.ui.updatealbum.UpdateAlbumActivity;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView recyclerView;
    private List<Album> albumList = new ArrayList<>();
    private AlbumAdapter adapter;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler handlers;
    private ActivityMainBinding binding;
    private static final String ALBUM_KEY = "album";
    private SearchView searchView;
    private List<Album> filteredAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        getAllAlbums();
        handlers = new MainActivityClickHandler(this);
        binding.setClickHandlers(handlers);

        searchView = findViewById(R.id.search_view);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterSearch(newText);
                return true;
            }
        });
    }

    private void filterSearch(String newText) {
        newText = newText.toLowerCase();
        filteredAlbum = new ArrayList<>();
        for (Album album : albumList) {
            if (album.getTitle().toLowerCase().contains(newText)
                    || album.getArtist().toLowerCase().contains(newText)) {
                filteredAlbum.add(album);
            }
        }
        if (filteredAlbum.isEmpty() && !newText.isBlank()) {
            Toast.makeText(MainActivity.this, "No album found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(filteredAlbum);
        }
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albumList = albumsFromLiveData;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.recyclerView;
        adapter = new AlbumAdapter(this, albumList, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
    }



    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, UpdateAlbumActivity.class);
        if (filteredAlbum == null || filteredAlbum.isEmpty()) {
            i.putExtra(ALBUM_KEY, albumList.get(position));
        } else {
            i.putExtra(ALBUM_KEY, filteredAlbum.get(position));
        }
        startActivity(i);
    }
}