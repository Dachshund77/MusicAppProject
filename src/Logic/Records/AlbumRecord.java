package Logic.Records;

public class AlbumRecord {

    private int albumID;
    private String albumName;

    public AlbumRecord(int albumID, String albumName) {
        this.albumID = albumID;
        this.albumName = albumName;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public boolean equals(Object obj) {
        boolean returnBoolean = false;
        if (obj instanceof AlbumRecord) {
            AlbumRecord other = (AlbumRecord) obj;
            if (this.albumID == other.albumID) {
                returnBoolean = true;
            }
        }
        return returnBoolean;
    }

    @Override
    public int hashCode() {
        return albumID;
    }
}
