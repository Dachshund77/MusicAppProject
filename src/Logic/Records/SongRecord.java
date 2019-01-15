package Logic.Records;
import java.util.HashSet;

public class SongRecord {

    private int songID;
    private Integer length;
    private Integer nrOfListens;
    private String songName;
    private HashSet<ArtistRecord> artistRecords;
    private HashSet<AlbumRecord> albumRecords;
    private HashSet<String> genres;

    public SongRecord(int songID, Integer length, Integer nrOfListens, String songName) {
        this.songID = songID;
        this.length = length;
        this.nrOfListens = nrOfListens;
        this.songName = songName;
        this.artistRecords = new HashSet<>();
        this.albumRecords = new HashSet<>();
        this.genres = new HashSet<>();
    }

    public void addArtistRecord(ArtistRecord artistRecord){
        this.artistRecords.add(artistRecord);
    }

    public void addAlbumRecord(AlbumRecord albumRecord){
        this.albumRecords.add(albumRecord);
    }

    public void addGenre(String genre){
        this.genres.add(genre);
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getNrOfListens() {
        return nrOfListens;
    }

    public void setNrOfListens(Integer nrOfListens) {
        this.nrOfListens = nrOfListens;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public HashSet<ArtistRecord> getArtistRecords() {
        return artistRecords;
    }

    public void setArtistRecords(HashSet<ArtistRecord> artistRecords) {
        this.artistRecords = artistRecords;
    }

    public HashSet<AlbumRecord> getAlbumRecords() {
        return albumRecords;
    }

    public void setAlbumRecords(HashSet<AlbumRecord> albumRecords) {
        this.albumRecords = albumRecords;
    }

    public HashSet<String> getGenres() {
        return genres;
    }

    public void setGenres(HashSet<String> genres) {
        this.genres = genres;
    }
}