package Database;

import Logic.Player.MusicPlayer;
import Logic.Records.AlbumRecord;
import Logic.Records.ArtistRecord;
import Logic.Records.PlayListRecord;
import Logic.Records.SongRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
        }
        MusicPlayer.removeFromPlayList(fldSongID);
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

    public static void incrementNrListens(int songID) {
        // get current nrOfListens
        ArrayList<Object[]> tempObjectArrayList = DB.select("SELECT fldNrListens FROM tblSongs WHERE fldSongID ="+songID);

        // unpack returns values
        Object[] objectArray = tempObjectArrayList.get(0);

        int oldValue = (Integer)objectArray[0];
        int newValue = oldValue + 1;

        // write new
        DB.execute("UPDATE tblSongs SET fldNrListens = "+newValue+" WHERE fldSongID= "+songID);
    }

    public static ArrayList<Integer> getSongIDs(int playListID){
        ArrayList<Integer> returnArrayList = new ArrayList<>();
        //Getting values
        ArrayList<Object[]> tempObjectArray = DB.select("SELECT fldSongID FROM tblSongsPlayListsBridge WHERE fldPlayListID = "+playListID);

        // Unpacking values
        for (Object[] objects : tempObjectArray) {
            for (Object object : objects) {
                returnArrayList.add((Integer)object);
            }
        }
        return returnArrayList;
    }

    public static SongRecord getSongRecord(int fldSongID) { //TODO untested and also not clean
        SongRecord returnSongRecord = null;

        //Building the Query
        String query = "SELECT tblSongs.fldSongID, fldLength, fldNrListens, fldSongName, tblArtists.*, tblAlbums.fldAlbumID, tblAlbums.fldAlbumName, tblGenres.fldGenreName, fldSongFile, tblAlbums.fldAlbumPicture " +
                "FROM tblSongs " +
                "FULL OUTER JOIN tblSongsArtistsBridge ON tblSongs.fldSongID = tblSongsArtistsBridge.fldSongID " +
                "FULL OUTER JOIN tblArtists ON tblSongsArtistsBridge.fldArtistID = tblArtists.fldArtistID " +
                "FULL OUTER JOIN tblSongsAlbumsBridge ON tblSongs.fldSongID = tblSongsAlbumsBridge.fldSongID " +
                "FULL OUTER JOIN tblAlbums ON tblSongsAlbumsBridge.fldAlbumID = tblAlbums.fldAlbumID " +
                "FULL OUTER JOIN tblSongsGenresBridge ON tblSongs.fldSongID = tblSongsGenresBridge.fldSongID " +
                "FULL OUTER JOIN tblGenres ON tblGenres.fldGenreName = tblSongsGenresBridge.fldGenreName " +
                "WHERE tblSongs.fldSongID = " + fldSongID;
        //Executing the Query
        ArrayList<Object[]> songsQuery = DB.select(query);
        // Retrieving Data
        for (Object[] objects : songsQuery) {
            if (returnSongRecord == null) {
                int songID = (int) objects[0];
                Integer length = (Integer) objects[1];
                Integer nrListens = (Integer) objects[2];
                String songName = (String) objects[3];
                int artistID = (int) objects[4];
                String artist = (String) objects[5];
                int albumID = (int) objects[6];
                String albumName = (String) objects[7];
                String genre = (String) objects[8];
                File songFile = convertToFile((byte[]) objects[9], ".mp3");
                File imageFile = convertToFile((byte[]) objects[10], ".jpg");

                ArtistRecord artistRecord = new ArtistRecord(artistID, artist);
                AlbumRecord albumRecord = new AlbumRecord(albumID, albumName, imageFile);
                returnSongRecord = new SongRecord(songID, length, nrListens, songName, artistRecord, albumRecord, genre, songFile);
            } else {
                int artistID = (int) objects[4];
                String artist = (String) objects[5];
                int albumID = (int) objects[6];
                String albumName = (String) objects[7];
                String genre = (String) objects[8];
                File imageFile = convertToFile((byte[]) objects[10], ".jpg");

                ArtistRecord artistRecord = new ArtistRecord(artistID, artist);
                AlbumRecord albumRecord = new AlbumRecord(albumID, albumName, imageFile);

                returnSongRecord.addArtistRecord(artistRecord);
                returnSongRecord.addAlbumRecord(albumRecord);
                returnSongRecord.addGenre(genre);
            }
        }
        return returnSongRecord;
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
        ArrayList<Object[]> songsQuery = DB.select(builder.toString());

        for (Object[] objects : songsQuery) {
            int songID = (int) objects[0];
            Integer length = (Integer) objects[1];
            Integer nrListens = (Integer) objects[2];
            String songName = (String) objects[3];
            int artistID = (int) objects[4];
            String artist = (String) objects[5];
            int albumID = (int) objects[6];
            String albumName = (String) objects[7];
            String genre = (String) objects[8];

            SongRecord tempSongRecord = new SongRecord(songID, length, nrListens, songName);
            if (returnArrayList.contains(tempSongRecord)) {
                int index = returnArrayList.indexOf(tempSongRecord);
                tempSongRecord = returnArrayList.get(index);
                ArtistRecord tempArtistRecord = new ArtistRecord(artistID, artist);
                AlbumRecord tempAlbumRecord = new AlbumRecord(albumID, albumName);
                tempSongRecord.addArtistRecord(tempArtistRecord);
                tempSongRecord.addAlbumRecord(tempAlbumRecord);
                tempSongRecord.addGenre(genre);
            } else {
                ArtistRecord tempArtistRecord = new ArtistRecord(artistID, artist);
                AlbumRecord tempAlbumRecord = new AlbumRecord(albumID, albumName);
                tempSongRecord.addArtistRecord(tempArtistRecord);
                tempSongRecord.addAlbumRecord(tempAlbumRecord);
                tempSongRecord.addGenre(genre);
                returnArrayList.add(tempSongRecord);
            }
        }
        return returnArrayList;
    }

    public static ArrayList<PlayListRecord> findAndGetPlayListRecord(String fldPlayListName, String fldSongName, String fldArtist, String fldAlbum, String fldGenre) {
        // This is by far the ugliest class i written in a long time, sorry.
        ArrayList<PlayListRecord> returnArrayList = new ArrayList<>();
        //Constructing the Query
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT tblPlayLists.fldPlayListID, fldPlayListName, tblSongs.fldSongID, fldLength, fldNrListens, fldSongName, tblArtists.*, tblAlbums.fldAlbumID, tblAlbums.fldAlbumName, tblGenres.fldGenreName " +
                "FROM tblPlayLists " +
                "FULL OUTER JOIN tblSongsPlayListsBridge ON tblPlayLists.fldPlayListID = tblSongsPlayListsBridge.fldPlayListID " +
                "FULL OUTER JOIN tblSongs ON tblSongsPlayListsBridge.fldSongID = tblSongs.fldSongID " +
                "FULL OUTER JOIN tblSongsArtistsBridge ON tblSongs.fldSongID = tblSongsArtistsBridge.fldSongID " +
                "FULL OUTER JOIN tblArtists ON tblSongsArtistsBridge.fldArtistID = tblArtists.fldArtistID " +
                "FULL OUTER JOIN tblSongsAlbumsBridge ON tblSongs.fldSongID = tblSongsAlbumsBridge.fldSongID " +
                "FULL OUTER JOIN tblAlbums ON tblSongsAlbumsBridge.fldAlbumID = tblAlbums.fldAlbumID " +
                "FULL OUTER JOIN tblSongsGenresBridge ON tblSongs.fldSongID = tblSongsGenresBridge.fldSongID " +
                "FULL OUTER JOIN tblGenres ON tblGenres.fldGenreName = tblSongsGenresBridge.fldGenreName "
        );
        if (fldPlayListName != null || fldSongName != null || fldArtist != null || fldAlbum != null || fldGenre != null) {
            builder.append("WHERE ");
            if (fldPlayListName != null) {
                builder.append("tbl.PlayLists.fldPlayListID LIKE '%").append(fldPlayListName).append("%'");
                builder.append(" AND ");
            }
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
        ArrayList<Object[]> songsQuery = DB.select(builder.toString());
        // Building the songRecords List
        for (Object[] objects : songsQuery) {
            int playListID = (int) objects[0];
            String playListName = (String) objects[1];
            int songID = (int) objects[2];
            Integer length = (Integer) objects[3];
            Integer nrListens = (Integer) objects[4];
            String songName = (String) objects[5];
            int artistID = (int) objects[6];
            String artist = (String) objects[7];
            int albumID = (int) objects[8];
            String albumName = (String) objects[9];
            String genre = (String) objects[10];

            PlayListRecord tempPlayListRecord = new PlayListRecord(playListID, playListName);
            if (returnArrayList.contains(tempPlayListRecord)) { // If the PlayListRecord exist already in the returnArray
                int index = returnArrayList.indexOf(tempPlayListRecord);
                tempPlayListRecord = returnArrayList.get(index);

                SongRecord tempSongRecord = new SongRecord(songID, length, nrListens, songName);
                if (tempPlayListRecord.getSongRecords().contains(tempSongRecord)) { // If the SongRecord exists already in the PlayListRecord

                    //Finding the specific object
                    tempSongRecord = findSongRecord(tempPlayListRecord, tempSongRecord);

                    // Preparing objects
                    ArtistRecord artistRecord = new ArtistRecord(artistID, artist);
                    AlbumRecord albumRecord = new AlbumRecord(albumID, albumName);

                    // Adding values to the specific object
                    tempSongRecord.addArtistRecord(artistRecord);
                    tempSongRecord.addAlbumRecord(albumRecord);
                    tempSongRecord.addGenre(genre);
                } else { // If the Song Record does not exist already in the PlayListRecord

                    // Preparing objects
                    ArtistRecord artistRecord = new ArtistRecord(artistID, artist);
                    AlbumRecord albumRecord = new AlbumRecord(albumID, albumName);

                    //adding values to new SongRecord
                    tempSongRecord.addArtistRecord(artistRecord);
                    tempSongRecord.addAlbumRecord(albumRecord);
                    tempSongRecord.addGenre(genre);

                    // Adding this songRecord
                    tempPlayListRecord.addSongRecord(tempSongRecord);
                }

            } else { // If the PlayListRecord does not exist already in the returnArray

                // Preparing objects
                SongRecord tempSongRecord = new SongRecord(songID, length, nrListens, songName);
                ArtistRecord artistRecord = new ArtistRecord(artistID, artist);
                AlbumRecord albumRecord = new AlbumRecord(albumID, albumName);

                //adding values to new SongRecord
                tempSongRecord.addArtistRecord(artistRecord);
                tempSongRecord.addAlbumRecord(albumRecord);
                tempSongRecord.addGenre(genre);

                // add this to the PlayListRecord and to the arrayList
                tempPlayListRecord.addSongRecord(tempSongRecord);
                returnArrayList.add(tempPlayListRecord);
            }
        }
        return returnArrayList;
    }

    public static void changePlayList(int playListID, int[] songIDs) {

        //Deleting bridges
        DB.execute("DELETE FROM tblSongsPlayListsBridge WHERE fldPlayListID ="+playListID);

        // We need to load up the String[][] array
        String[][] batchArray = new String[songIDs.length][2];
        for (int i = 0; i < batchArray.length; i++) {
            batchArray[i][0] = Integer.toString(songIDs[i]);
            batchArray[i][1] = Integer.toString(playListID);
        }
        // execute batch
        DB.executePreparedBatch("INSERT INTO tblSongsPlayListsBridge (fldSongID, fldPlayListID) VALUES(?,?)",batchArray);
    }

    private static File convertToFile(byte[] byteArray, String suffix) { //TODO We want to delete the file on system exit
        File returnFile = null;
        try {
            returnFile = new File("../Resources/Temp/tempFile" + Arrays.hashCode(byteArray) + suffix);
            FileOutputStream fileOutputStream = new FileOutputStream(returnFile);
            fileOutputStream.write(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnFile;
    }

    private static SongRecord findSongRecord(PlayListRecord playListRecord, SongRecord search) {
        HashSet<SongRecord> songRecords = playListRecord.getSongRecords();
        for (SongRecord songRecord : songRecords) {
            if (songRecord.equals(search)) {
                return songRecord;
            }
        }
        return null;
    }
}
