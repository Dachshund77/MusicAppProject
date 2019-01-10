package Database;

import java.io.File;
import java.util.ArrayList;

/**
 * HElpertuff whatever
 */
public class DbHelper {
    /**
     * Get arraylist of Playlist IDs from Song ID
     * @param songID
     * @return
     */
    public ArrayList<Integer> getPlaylistID(int songID) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        DB.selectSQL("SELECT fldPlaylistID FROM tblSongsPlaylistsBridge WHERE fldSongID = ‘" + songID + "'");
        do {
            String data = DB.getDisplayData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                results.add(Integer.parseInt(data));
            }
        } while (true);
        return results;
    }

    /**
     * Get arraylist of Artist IDs from Song ID
     * @param songID
     * @return
     */
    public ArrayList<Integer> getArtistID(int songID) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        DB.selectSQL("SELECT fldArtistsID FROM tblSongsArtistsBridge WHERE fldSongID = ‘" + songID + "'");
        do {
            String data = DB.getDisplayData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                results.add(Integer.parseInt(data));
            }
        } while (true);
        return results;
    }

    /**
     * Get arraylist of Genres from Song ID
     * @param songID
     * @return
     */
    public ArrayList<String> getGenreID(int songID) {
        ArrayList<String> results = new ArrayList<String>();
        DB.selectSQL("SELECT fldGenreName FROM tblSongsGenresBridge WHERE fldSongID = ‘" + songID + "'");
        do {
            String data = DB.getDisplayData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                results.add(data);
            }
        } while (true);
        return results;
    }

    /**
     *  Get arraylist of Album IDs from Song ID
     * @param songID
     * @return
     */
    public ArrayList<Integer> getAlbumID(int songID) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        DB.selectSQL("SELECT fldAlbumID FROM tblSongsArtistsBridge WHERE fldSongID = ‘" + songID + "'");
        do {
            String data = DB.getDisplayData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                results.add(Integer.parseInt(data));
            }
        } while (true);
        return results;
    }

    /**
     * Insert Album to DB
     * @param albumName
     * @param albumPicture
     */
    public void insertAlbum(String albumName, File albumPicture) {
        DB.insertSQL("INSERT INTO tblAlbums (‘" + albumName + "', " + albumPicture + ")");
    }

    /**
     * Insert Genre to DB
     * @param genreName
     */
    public void insertGenre(String genreName) {
        DB.insertSQL("INSERT INTO tblGenres(‘" + genreName + "')");
    }

    /**
     * Insert Artist to DB
     * @param artistName
     */
    public void insertArtist(String artistName) {
        DB.insertSQL("INSERT INTO tblArtists(‘" + artistName + "')");
    }

    /**
     * Insert Playlist to DB
     * @param playlistName
     */
    public void insertPlaylist(String playlistName) {
        DB.insertSQL("INSERT INTO tblPlaylists(‘" + playlistName + "')");
    }

    /**
     * Insert Song to DB
     * @param songLength
     * @param nrOfListens
     * @param songName
     * @param songFile
     */
    public void insertSong(int songLength, int nrOfListens, String songName, File songFile) {
        DB.insertSQL("INSERT INTO tblSongs(‘" + songLength + "',‘" + nrOfListens + "',‘" + songName + "',‘" + songFile + "')");
    }

    /**
     * Change Playlist
     * @param playlistName
     * @param playlistID
     * @param songList
     */
    public void updatePlaylist(String playlistName, int playlistID, ArrayList<Integer> songList) {
        /* Has to be this way, otherwise it's hell. Run the update and delete once each, put insert into foreach*/
        DB.updateSQL("UPDATE tblPlaylists SET fldPlaylistName = ‘" + playlistName + "' WHERE fldPlaylistID = ‘" + playlistID + "'");
        DB.deleteSQL("DELETE tblSongsPlaylistsBridge WHERE fldPlaylistID = ‘" + playlistID + "'");
        for (int songID : songList) {
            DB.insertSQL("INSERT INTO tblSongsPlaylistsBridge(‘" + playlistID + "',’" + songID + "')");
        }
    }

    /**
     * Change Album Name by Album ID
     * @param albumName
     * @param albumID
     */
    void updateAlbumName(String albumName, int albumID) {
        DB.updateSQL("UPDATE tblAlbums SET fldAlbumName = ‘albumName’ WHERE fldAlbumID = ‘" + albumID + "'");
    }

    /**
     * Change Picture by Album ID
     * @param albumID
     * @param albumPicture
     */
    void updateAlbumPicture(int albumID, File albumPicture) {
        DB.updateSQL("UPDATE tblAlbums SET fldAlbumPicture = '" + albumPicture + "' WHERE fldAlbumID = ‘" + albumID + "'");
    }

    /**
     * retrieves a song file from DB based on ID
     * @param songID
     * @return
     */
    public File getSong(int songID) {
        String temporaryRepository = "";
        DB.selectSQL("SELECT fldSongFile FROM tblSongs WHERE fldSongID = '" + songID + "'");
        do {
            String data = DB.getDisplayData();
            if (data.equals(DB.NOMOREDATA)) {
                break;
            } else {
                temporaryRepository+= data;
            }
        } while (true);
        File results = new File (temporaryRepository);
        return results;
    }

}
