package Controllers;

import Logic.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;

/**
 * This scene will be used to find a playlist and start it.
 * The user can either go back to {@link MainController} or if he/she want to edit a playlist go
 * to {@link UpdatePlayListController}.
 */
public class PlayListController {

    @FXML
    private Button editPlayListButton;
    @FXML
    private Button deletePlayListButton;
    @FXML
    private ListView playListViewList;

    @FXML
    public void handleAddPlayList(ActionEvent event) {
    }

    @FXML
    public void handleEditPlayList(ActionEvent event) {
        ViewController.UPDATE_PLAYLIST.load();
    }

    @FXML
    public void handleDeletePlayList(ActionEvent event) {
    }

    /**
     * Will change the scene to the {@link MainController}.
     * @param event A Button click
     */
    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.MAIN.load();
    }

    @FXML
    public void handleSearch(KeyEvent keyEvent) {
    }

    @FXML
    public void handleClearSearch(ActionEvent event) {
    }
}
