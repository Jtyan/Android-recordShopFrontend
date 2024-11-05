package learningprogramming.academy.recordshopfrontend.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import learningprogramming.academy.recordshopfrontend.BR;

public class Album extends BaseObservable implements Parcelable {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("artist")
    private String artist;
    @SerializedName("releasedYear")
    private String releasedYear;
    @SerializedName("genre")
    private String genre;
    @SerializedName("stock")
    private int stock;
    @SerializedName("albumCoverURL")
    private String albumCoverURL;

    public Album(long id, String title, String artist, String releasedYear, String genre, int stock, String albumCoverURL) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.genre = genre;
        this.stock = stock;
        this.albumCoverURL = albumCoverURL;
    }

    public Album() {
    }

    protected Album(Parcel in) {
        id = in.readLong();
        title = in.readString();
        artist = in.readString();
        releasedYear = in.readString();
        genre = in.readString();
        stock = in.readInt();
        albumCoverURL = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);

    }
    @Bindable
    public String getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
        notifyPropertyChanged(BR.releasedYear);
    }
    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public String getAlbumCoverURL() {
        return artist;
    }

    public void setAlbumCoverURL(String albumCoverURL) {
        this.albumCoverURL = albumCoverURL;
        notifyPropertyChanged(BR.albumCoverURL);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeString(releasedYear);
        dest.writeString(genre);
        dest.writeInt(stock);
        dest.writeString(albumCoverURL);
    }
}
