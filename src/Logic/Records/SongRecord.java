package Logic.Records;
import java.util.Set;

public class SongRecord {

    private int songID;
    private Integer length;
    private Integer nrOfListens;
    private String songName;
    private Set<ArtistRecord> artistRecords;
    private Set<AlbumRecord> albumRecords;
    private Set<String> genres;

    public SongRecord(int songID, Integer length, Integer nrOfListens, String songName, Set<ArtistRecord> artistRecords, Set<AlbumRecord> albumRecords, Set<String> genres) {
        this.songID = songID;
        this.length = length;
        this.nrOfListens = nrOfListens;
        this.songName = songName;
        this.artistRecords = artistRecords;
        this.albumRecords = albumRecords;
        this.genres = genres;
    }
}