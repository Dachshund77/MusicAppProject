package Controllers;

import Logic.Player.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this scene the user can Add, Edit or delete a Genre.
 */
public class UpdateGenreController extends Controller{

    @FXML
    private TextField newGenreTextField;
    @FXML
    private MenuButton genreMenuButton;

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.UPDATE_SONG.load();

    }

    @FXML
    public void handleAddSong(ActionEvent event) {
    }

    @FXML
    public void handleDeleteGenre(ActionEvent event) {
    }
}
