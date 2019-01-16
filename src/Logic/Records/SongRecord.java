package Logic.Records;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class SongRecord {

    private int songID;
    private Integer length;
    private Integer nrOfListens;
    private String songName;
    private HashSet<ArtistRecord> artistRecords;
    private HashSet<AlbumRecord> albumRecords;
    private HashSet<String> genres;
    private File songFile;

    public SongRecord(int songID, Integer length, Integer nrOfListens, String songName) {
        this.songID = songID;
        this.length = length;
        this.nrOfListens = nrOfListens;
        this.songName = songName;
        this.artistRecords = new HashSet<>();
        this.albumRecords = new HashSet<>();
        this.genres = new HashSet<>();
        this.songFile = null;
    }

    public SongRecord(int songID, Integer length, Integer nrOfListens, String songName, ArtistRecord artistRecord, AlbumRecord albumRecord, String genre, File songFile) {
        this.songID = songID;
        this.length = length;
        this.nrOfListens = nrOfListens;
        this.songName = songName;
        this.artistRecords = new HashSet<>();
        this.artistRecords.add(artistRecord);
        this.albumRecords = new HashSet<>();
        this.albumRecords.add(albumRecord);
        this.genres = new HashSet<>();
        this.genres.add(genre);
        this.songFile = songFile;
    }

    public File getSongFile() {
        return songFile;
    }

    public void setSongFile(File songFile) {
        this.songFile = songFile;
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

    @Override
    public boolean equals(Object obj) {
        boolean returnBoolean = false;
        if (obj instanceof SongRecord) {
            SongRecord other = (SongRecord) obj;
            if (this.songID == other.songID) {
                returnBoolean = true;
            }
        }
        return returnBoolean;
    }

    @Override
    public int hashCode() {
        return songID;
    }
}