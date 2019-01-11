package Controllers;

import Logic.ViewController;
import Logic.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;

/**
 * In this scene the user can pick a song to that will be added to the playlist.
 */
public class AddSongToPlayListController {

    @FXML
    private ListView songListViewList;

    @FXML
    public void handleSearch(KeyEvent keyEvent) {
    }

    @FXML
    public void handleClearSearch(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.UPDATE_PLAYLIST.load();
    }

    @FXML
    public void handleAddSongToPlayList(ActionEvent event) {
    }
}
