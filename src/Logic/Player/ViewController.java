package Logic.Player;

import Controllers.Controllers;
import Controllers.UpdateSongController;
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

    ViewController(String url) {
        this.URL = url;
    }

    /**
     * Loads a new scene.
     * The scene URL is defined in the Enum constructor.
     *
     * @see Main
     */
    public void load() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(URL));
            Main.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a new scene and passes a value to the new controller.
     * The scene URL is defined in the Enum constructor.
     * <br><br>
     * <p>
     * <font color="red">
     * IMPORTANT:
     * </font>
     * In order to pass a value the new controller needs to extends the 'Controller' abstract class and override its methods.
     * </p>
     *
     * @see Controllers
     * @see Main
     */
            /*
            If another parameter needs to passed follow thees steps:
            1) Create a initValues( - your parameters -) in the Controllers interface
            2) Create the same initValues in the Abstract class Controller, and please keep the style of error messages
            3) Copy paste this method in here and change the parameter
            4) Make sure you call the correct initValues in this method
            */
    public void load(String string) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(URL));
            Parent root = loader.load();

            Controllers newController = loader.getController();

            newController.initValues(string);

            Main.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
