package Controllers;

import Logic.ViewController;
import Logic.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;

/**
 * In this scene the user can see the content of a Playlist and delete songs.
 * If the user want to add song he/she has to navigate to {@link AddSongToPlayListController}.
 */
public class UpdatePlayListController {

    @FXML
    private MusicPlayerController musicPlayerController;
    @FXML
    private Button deleteButton;
    @FXML
    private ListView songListViewList;

    /**
     * Initializer that will set the current {@link MusicPlayerController} to the {@link MusicPlayer} Logic.
     * The MusicPlayer Logic and visuals will not be accessible if not set on initialization.
     * @see MusicPlayer
     */
    public void initialize(){
        MusicPlayer.setMusicPlayerController(musicPlayerController);
    }

    @FXML
    public void handleAddSongToPlayList(ActionEvent event) {
        ViewController.ADD_SONG_TO_PLAYLIST.load();
    }

    @FXML
    public void handleDeleteSongFromPlayList(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.PLAYLIST.load();

    }

    @FXML
    public void handleSearch(KeyEvent keyEvent) {
    }

    @FXML
    public void handleClearSearch(ActionEvent event) {
    }

    @FXML
    public void handleInputCompletion(ActionEvent event) {
    }
}
