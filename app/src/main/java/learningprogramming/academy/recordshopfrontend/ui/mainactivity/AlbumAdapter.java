package learningprogramming.academy.recordshopfrontend.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import learningprogramming.academy.recordshopfrontend.R;
import learningprogramming.academy.recordshopfrontend.databinding.AlbumItemBinding;
import learningprogramming.academy.recordshopfrontend.model.Album;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private Context context;
    private List<Album> albumList;

    public AlbumAdapter(Context context, List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.album_item,
                parent,
                false);
        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumItemBinding.setAlbum(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        private AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }
    }
}
