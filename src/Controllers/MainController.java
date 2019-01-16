package Controllers;

import Logic.Player.MusicPlayer;
import Logic.Player.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The main window. Here we will display information about the current song like picture artist etc.
 * From this scene we can navigate either to {@link SongListController} or {@link PlayListController}.
 */
public class MainController extends Controller{

    @FXML
    private Label songInfoLabel;
    @FXML
    private ImageView albumImage;

    /**
     * We need to set the MainController for the {@link MusicPlayer}, since its the Musicplayer that controls those Labels.
     */
    public void initialize(){
        MusicPlayer.setMainController(this);
        albumImage.setImage(MusicPlayer.getAlbumImage());
    }

    /**
     * Will change the scene to the {@link PlayListController}.
     * @param event A Button click
     */
    @FXML
    public void navigateToPlayLists(ActionEvent event) {
        ViewController.PLAYLIST.load();
    }

    /**
     * Will change the scene to the {@link SongListController}
     * @param event A Button click
     */
    @FXML
    public void navigateToSongs(ActionEvent event) {
        ViewController.SONGLIST.load();
    }

    public Label getSongInfoLabel() {
        return songInfoLabel;
    }

    public void setAlbumImage(Image image) {
        albumImage.setImage(image);
    }
}
