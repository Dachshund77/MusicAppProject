package Controllers;

import Logic.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this scene the user can add, delete or edit an Artist.
 */
public class UpdateArtistController {

    @FXML
    private TextField newArtistTextField;
    @FXML
    private Button addArtistButton;
    @FXML
    private Button deleteArtistButton;
    @FXML
    private MenuButton artistMenuButton;

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.UPDATE_SONG.load();
    }

    @FXML
    public void handleAddArtist(ActionEvent event) {
    }

    @FXML
    public void handleDeleteArtist(ActionEvent event) {
    }
}
