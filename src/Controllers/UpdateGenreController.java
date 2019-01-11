package Controllers;

import Logic.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this scene the user can Add, Edit or delete a Genre.
 */
public class UpdateGenreController {

    @FXML
    private MusicPlayerController musicPlayerController;
    @FXML
    private TextField newGenreTextField;
    @FXML
    private MenuButton genreMenuButton;

    /**
     * Initializer that will set the current {@link MusicPlayerController} to the {@link MusicPlayer} Logic.
     * The MusicPlayer Logic and visuals will not be accessible if not set on initialization.
     * @see MusicPlayer
     */
    public void initialize(){
        MusicPlayer.setMusicPlayerController(musicPlayerController);
    }

    @FXML
    public void navigateBack(ActionEvent event) {
    }

    @FXML
    public void handleAddSong(ActionEvent event) {
    }

    @FXML
    public void handleDeleteGenre(ActionEvent event) {
    }
}
