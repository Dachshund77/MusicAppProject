package Logic;

import Views.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

/**
 * Can be used to change the scenes easily.
 * The enum class will store the relative path to the fxml so that we don't need to type it multiple times.
 */
public enum ViewController {
    MAIN("../Fxmls/Main.fxml"),
    MUSIC_PLAYER("../Fxmls/MusicPlayer.fxml"),
    PLAYLIST("../Fxmls/PlayList.fxml"),
    SONGLIST("../Fxmls/SongList.fxml"),
    UPDATE_ALBUM("../Fxmls/UpdateAlbum.fxml"),
    UPDATE_ARTIST("../Fxmls/UpdateArtist.fxml"),
    UPDATE_GENRE("../Fxmls/UpdateGenre.fxml"),
    UPDATE_PLAYLIST("../Fxmls/UpdatePlayList.fxml"),
    UPDATE_SONG("../Fxmls/UpdateSong.fxml"),
    ADD_SONG_TO_PLAYLIST("../Fxmls/AddSongToPlayList.fxml");

    private final String URL;

    ViewController(String url){
        this.URL = url;
    }

    public void load(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(URL));
            Main.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
