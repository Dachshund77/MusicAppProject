package Database;

import Logic.Records.AlbumRecord;
import Logic.Records.ArtistRecord;
import Logic.Records.SongRecord;

import java.io.File;
import java.util.ArrayList;

/**
 * HElpertuff whatever
 */
public class DbHelper {

    public static boolean insertSong(Integer fldLength, Integer fldNrListens, String fldSongName, File fldSongFile) {
        boolean returnBoolean = false;
        if (DB.executeWithFile("INSERT INTO tblSongs VALUES(" + fldLength + "," + fldNrListens + "," + fldSongName + ",?)", fldSongFile)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertPlayList(String fldPlayListName) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblPlayLists VALUES(" + fldPlayListName + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;

    }

    public static boolean insertArtist(String fldArtistName) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblArtists VALUES(" + fldArtistName + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertGenre(String fldGenreName) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblGenres VALUES(" + fldGenreName + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertAlbum(String fldAlbumName, File fldAlbumPicture) { //TODO will probably create a NullPointerException if not all values are provided
        boolean returnBoolean = false;
        if (DB.executeWithFile("INSERT INTO tblAlbums VALUES(" + fldAlbumName + ",?)", fldAlbumPicture)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertSongsArtitsBridge(int fldSongID, int fldArtistID) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblSongsArtistsBridge VALUES(" + fldSongID + "," + fldArtistID + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertSongsGenresBridge(int fldSongID, String fldGenreName) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblSongsGenresBridge VALUES(" + fldSongID + "," + fldGenreName + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertSongsAlbumsBridge(int fldSongID, int fldAlbumID) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblSongsAlbumsBridge VALUES(" + fldSongID + "," + fldAlbumID + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean insertSongPlayListBridge(int fldSongID, int fldPlayListID) {
        boolean returnBoolean = false;
        if (DB.execute("INSERT INTO tblSongsPlayListsBridge VALUES(" + fldSongID + "," + fldPlayListID + ")")) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean updateSong(int fldSongID, Integer fldLength, Integer fldNrListens, String fldSongName, File fldSongFile) {
        boolean returnBoolean = false;
        if (DB.executeWithFile("UPDATE tblSongs SET fldLength=" + fldLength + ", fldNrListens=" + fldNrListens + ",fldSongName =" + fldSongName + ",fldSongFile = ? WHERE fldSongID =" + fldSongID, fldSongFile)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean updatePlayList(int fldPlayListID, String fldPlayListName) {
        boolean returnBoolean = false;
        if (DB.execute("UPDATE tblPlayLists SET fldPlayListName =" + fldPlayListName + " WHERE fldPlayListID = " + fldPlayListID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean updateArtist(int fldArtistID, String fldArtistName) {
        boolean returnBoolean = false;
        if (DB.execute("UPDATE tblArtists SET fldArtistName =" + fldArtistName + " WHERE fldArtistID = " + fldArtistID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean updateGenre(String fldGenreName) {
        boolean returnBoolean = false;
        if (DB.execute("UPDATE tblGenres SET fldGenreName =" + fldGenreName + " WHERE fldGenreName = " + fldGenreName)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean updateAlbum(int fldAlbumID, String fldAlbumName, File fldAlbumPicture) { //TODO will probably create a NullPointerException if not all values are provided
        boolean returnBoolean = false;
        if (DB.executeWithFile("UPDATE tblAlbums SET fldAlbumName=" + fldAlbumName + ", fldAlbumPicture = ?  WHERE fldSongID =" + fldAlbumID, fldAlbumPicture)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteSong(int fldSongID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblSongs WHERE fldSongID =" + fldSongID)) {
            returnBoolean = true;
        } //TODO update current playlist
        return returnBoolean;
    }

    public static boolean deletePlayList(int fldPlayListID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblPlayLists WHERE fldPlayListID =" + fldPlayListID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteArtist(int fldArtistID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblArtists WHERE fldArtistID =" + fldArtistID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteGenre(String fldGenreName) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblGenres WHERE fldGenreName =" + fldGenreName)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteAlbum(int fldAlbumID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblAlbums WHERE fldAlbumID =" + fldAlbumID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteSongsArtitsBridge(int fldSongID, int fldArtistID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblSongsArtistsBridge WHERE fldSongID =" + fldSongID + " AND fldArtistID=" + fldArtistID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteSongsGenresBridge(int fldSongID, String fldGenreName) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblSongsGenresBridge WHERE fldSongID =" + fldSongID + " AND fldArtistID=" + fldGenreName)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteSongsAlbumsBridge(int fldSongID, int fldAlbumID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblSongsAlbumsBridge WHERE fldSongID =" + fldSongID + " AND fldArtistID=" + fldAlbumID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static boolean deleteSongPlayListBridge(int fldSongID, int fldPlayListID) {
        boolean returnBoolean = false;
        if (DB.execute("DELETE FROM tblSongsPlayListsBridge WHERE fldSongID =" + fldSongID + " AND fldArtistID=" + fldPlayListID)) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static File getSong(int SongID) {
        return new File("test");
    }

    public static Object[] findAndGetSongRecords(int fldSongID) { //TODO untested and also not clean
        Object[] returnArray = new Object[8];
        Object[] temp;

        ArrayList<Object[]> songsQuery = DB.select("SELECT * FROM tblSongs WHERE fldSongID =" + fldSongID);
        temp = songsQuery.get(0);
        returnArray[0] = temp[0]; // fldSongId
        returnArray[1] = temp[1]; // fldLength
        returnArray[2] = temp[2]; // fldNrListens
        returnArray[3] = temp[3]; // fldSongName
        returnArray[4] = temp[4]; // fldSongFile (byte[])

        ArrayList<Object[]> artistQuery = DB.select("SELECT fldArtistName FROM tblArtists WHERE fldArtistID = (SELECT fldArtistID FROM tblSongsArtistsBridge WHERE fldSongID = " + fldSongID + " )");
        temp = artistQuery.get(0); //TODO i think there's an error here
        returnArray[5] = temp[0]; // fldArtistName[]

        ArrayList<Object[]> genreQuery = DB.select("SELECT fldGenreName FROM tblGenres WHERE fldGenreName = (SELECT fldGenreName FROM tblSongsGenresBridge WHERE fldSongID = " + fldSongID + " )");
        temp = genreQuery.get(0);
        returnArray[6] = temp[0]; // fldGenreName[]

        ArrayList<Object[]> albumQuery = DB.select("SELECT fldAlbumName FROM tblAlbums WHERE fldAlbumID = (SELECT fldAlbumID FROM tblSongsAlbumsBridge WHERE fldSongID = " + fldSongID + " )");
        temp = albumQuery.get(0);
        returnArray[7] = temp[0]; // fldAlbumName[]

        return returnArray;
    }

    public static ArrayList<SongRecord> findAndGetSongRecords(String fldSongName, String fldArtist, String fldAlbum, String fldGenre) {
        ArrayList<SongRecord> returnArrayList = new ArrayList<>();
        //Constructing the Query
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT tblSongs.fldSongID, fldLength, fldNrListens, fldSongName, tblArtists.*, tblAlbums.fldAlbumID, tblAlbums.fldAlbumName, tblGenres.fldGenreName " +
                "FROM tblSongs " +
                "FULL OUTER JOIN tblSongsArtistsBridge ON tblSongs.fldSongID = tblSongsArtistsBridge.fldSongID " +
                "FULL OUTER JOIN tblArtists ON tblSongsArtistsBridge.fldArtistID = tblArtists.fldArtistID " +
                "FULL OUTER JOIN tblSongsAlbumsBridge ON tblSongs.fldSongID = tblSongsAlbumsBridge.fldSongID " +
                "FULL OUTER JOIN tblAlbums ON tblSongsAlbumsBridge.fldAlbumID = tblAlbums.fldAlbumID " +
                "FULL OUTER JOIN tblSongsGenresBridge ON tblSongs.fldSongID = tblSongsGenresBridge.fldSongID " +
                "FULL OUTER JOIN tblGenres ON tblGenres.fldGenreName = tblSongsGenresBridge.fldGenreName "
        );
        if (fldSongName != null || fldArtist != null || fldAlbum != null || fldGenre != null) {
            builder.append("WHERE ");
            if (fldSongName != null) {
                builder.append("fldSongName LIKE '%").append(fldSongName).append("%'");
                builder.append(" AND ");
            }
            if (fldArtist != null) {
                builder.append("tblArtists.fldArtistName LIKE '%").append(fldArtist).append("%'");
                builder.append(" AND ");
            }
            if (fldAlbum != null) {
                builder.append("tblAlbums.fldAlbumName LIKE '%").append(fldAlbum).append("%'");
                builder.append(" AND ");
            }
            if (fldGenre != null) {
                builder.append("tblGenres.fldGenreName LIKE '%").append(fldGenre).append("%'");
                builder.append(" AND ");
            }
            builder.delete(builder.length() - 4, builder.length() - 1);
        }
        //Executing Query
        System.out.println(builder.toString());
        ArrayList<Object[]> songsQuery = DB.select(builder.toString());

        for (Object[] objects : songsQuery) {
            int songID = (int)objects[0];
            Integer length = (Integer)objects[1];
            Integer nrListens = (Integer)objects[2];
            String songName = (String)objects[3];
            int artistID = (int)objects[4];
            String artist = (String)objects[5];
            int albumID = (int)objects[6];
            String albumName = (String)objects[7];
            String genre = (String)objects[8];

            SongRecord tempSongRecord = new SongRecord(songID,length,nrListens,songName);
            if (returnArrayList.contains(tempSongRecord)){
                int index = returnArrayList.indexOf(tempSongRecord);
                tempSongRecord = returnArrayList.get(index);
                ArtistRecord tempArtistRecord = new ArtistRecord(artistID,artist);
                AlbumRecord tempAlbumRecord = new AlbumRecord(albumID,albumName);
                tempSongRecord.addArtistRecord(tempArtistRecord);
                tempSongRecord.addAlbumRecord(tempAlbumRecord);
                tempSongRecord.addGenre(genre);
            } else{
                ArtistRecord tempArtistRecord = new ArtistRecord(artistID,artist);
                AlbumRecord tempAlbumRecord = new AlbumRecord(albumID,albumName);
                tempSongRecord.addArtistRecord(tempArtistRecord);
                tempSongRecord.addAlbumRecord(tempAlbumRecord);
                tempSongRecord.addGenre(genre);
                returnArrayList.add(tempSongRecord);
            }
        }
        return returnArrayList;
    }

    public static ArrayList<Object[]> findAndGetPlayListRecord(String playListName, String songName, String artist, String album, String genre) {
        return new ArrayList<>();
    }

    public static void changePlayList(int playListID, int[] songIDs) {

    }

    private static boolean containsSongRecord(ArrayList<SongRecord> arrayList, int songID) {
        boolean returnBoolean = false;
        if (arrayList != null) {
            for (SongRecord songRecord : arrayList) {
                if (songRecord.getSongID() == songID) {
                    returnBoolean = true;
                }
            }
        }
        return returnBoolean;
    }
}
