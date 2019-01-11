package Controllers;

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
    private MusicPlayerController musicPlayerController;
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
    public void handleSearch(KeyEvent keyEvent) {
    }

    @FXML
    public void handleClearSearch(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
    }

    @FXML
    public void handleAddSongToPlayList(ActionEvent event) {
    }
}
