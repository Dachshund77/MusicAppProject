package Controllers;

import Logic.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * The main window. Here we will display information about the current song like picture artist etc.
 * From this scene we can navigate either to {@link SongListController} or {@link PlayListController}.
 */
public class MainController {

    @FXML
    private Label songInfoLabel;
    @FXML
    private ImageView albumImage;

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
}
