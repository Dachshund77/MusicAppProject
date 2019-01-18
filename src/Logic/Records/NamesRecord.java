package Logic.Records;

public class NamesRecord {
    private String songName;
    private String albumName;
    private String artistName;

    public NamesRecord (String songName, String artistName, String albumName)
    {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
