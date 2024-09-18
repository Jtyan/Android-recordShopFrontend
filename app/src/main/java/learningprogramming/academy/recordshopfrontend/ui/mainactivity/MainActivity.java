package learningprogramming.academy.recordshopfrontend.ui.mainactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Album> albumList = new ArrayList<>();
    AlbumAdapter adapter;
    MainActivityViewModel viewModel;
    ActivityMainBinding binding;

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
        adapter = new AlbumAdapter(this, albumList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
    }
}