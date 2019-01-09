package Controllers;

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

    @FXML
    public void navigateToPlayLists(ActionEvent event) {
    }

    @FXML
    public void navigateToSongs(ActionEvent event) {
    }
}
