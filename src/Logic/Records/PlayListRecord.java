package Logic.Records;

import java.util.HashSet;

public class PlayListRecord {

    private int playListID;
    private String name;
    private HashSet<SongRecord> songRecords;

    public PlayListRecord(int playListID, String name) {
        this.playListID = playListID;
        this.name = name;
        this.songRecords = new HashSet<>();
    }

    public void addSongRecord(SongRecord songRecord){
        this.songRecords.add(songRecord);
    }

    public int getPlayListID() {
        return playListID;
    }

    public void setPlayListID(int playListID) {
        this.playListID = playListID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<SongRecord> getSongRecords() {
        return songRecords;
    }

    public void setSongRecords(HashSet<SongRecord> songRecords) {
        this.songRecords = songRecords;
    }

    @Override
    public boolean equals(Object obj) {
        boolean returnBoolean = false;
        PlayListRecord other = (PlayListRecord) obj;
        if (this.playListID == other.playListID){
            returnBoolean = true;
        }
        return returnBoolean;
    }
}
