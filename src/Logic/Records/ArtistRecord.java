package Logic.Records;

public class ArtistRecord {

    private int artistID;
    private String artistName;

    public ArtistRecord(int artistID, String artistName) {
        this.artistID = artistID;
        this.artistName = artistName;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public boolean equals(Object obj) {
        boolean returnBoolean = false;
        ArtistRecord other = (ArtistRecord) obj;
        if (this.artistID == other.artistID){
            returnBoolean = true;
        }
        return returnBoolean;
    }
}
