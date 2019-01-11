package Controllers;

import Logic.MusicPlayer;
import Logic.ViewController;
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

    /**
     * Will change the scene to {@link MainController}.
     * @param event A button click
     */
    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.MAIN.load();
    }

    @FXML
    public void handleAddSong(ActionEvent event) {
    }

    @FXML
    public void handleEditSong(ActionEvent event) {
        ViewController.UPDATE_SONG.load();
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
