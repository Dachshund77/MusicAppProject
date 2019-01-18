package Logic.Records;

import java.io.File;

public class AlbumRecord {

    private int albumID;
    private String albumName;
    private File albumPicture;

    public AlbumRecord(int albumID, String albumName) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.albumPicture = null;
    }

    public AlbumRecord(int albumID, String albumName, File albumPicture) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.albumPicture = albumPicture;
    }

    public File getAlbumPicture() {
        return albumPicture;
    }

    public void setAlbumPicture(File albumPicture) {
        this.albumPicture = albumPicture;
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
