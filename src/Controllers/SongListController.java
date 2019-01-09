package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;

/**
 * In this window the user will be able to search for songs, play them or edit them.
 * This scene will take the user either back to {@link MainController} or if he want to edit/add songs to {@link UpdateSongController}.
 */
public class SongListController {

    @FXML
    private Button editSongButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private ListView songViewList;

    @FXML
    public void navigateBack(ActionEvent event) {
    }

    @FXML
    public void handleAddSong(ActionEvent event) {
    }

    @FXML
    public void handleEditSong(ActionEvent event) {
    }

    @FXML
    public void handleDeleteSong(ActionEvent event) {
    }

    @FXML
    public void handleSearch(KeyEvent keyEvent) {
    }

    @FXML
    public void handleClearSearch(ActionEvent event) {
    }
}
