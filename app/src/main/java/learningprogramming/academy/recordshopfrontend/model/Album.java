package learningprogramming.academy.recordshopfrontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("artist")
    private String artist;
    @SerializedName("releasedYear")
    private int releasedYear;
    @SerializedName("genre")
    private String genre;
    @SerializedName("stock")
    private int stock;

    public Album(long id, String title, String artist, int releasedYear, String genre, int stock) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.genre = genre;
        this.stock = stock;
    }

    public Album() {
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    @Bindable
    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }
    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
