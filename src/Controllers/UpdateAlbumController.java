package Controllers;

import Logic.Player.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this scene the user can Add, edit or Delete a Genre.
 */
public class UpdateAlbumController extends Controller{

    @FXML
    private TextField newAlbumTextField;
    @FXML
    private MenuButton albumMenuButton;

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.UPDATE_SONG.load();
    }

    @FXML
    public void handleAddAlbum(ActionEvent event) {
    }

    @FXML
    public void handleUpdateAlbumPicture(ActionEvent event) {
    }

    @FXML
    public void handleUpdateAlbumName(ActionEvent event) {
    }

    @FXML
    public void handleDeleteAlbum(ActionEvent event) {
    }
}
