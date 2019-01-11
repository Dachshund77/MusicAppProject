package Controllers;

import Logic.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this Scene the user will have the possibility to edit or add a Song.
 * If the user wants to Add a new Artist, Genre or Album he will need to use {@link UpdateArtistController}, {@link UpdateGenreController} or {@link UpdateAlbumController}.
 */
public class UpdateSongController {

    @FXML
    private MusicPlayerController musicPlayerController;
    @FXML
    private TextField songNameTextField;
    @FXML
    private MenuButton artistMenuButton;
    @FXML
    private MenuButton albumMenuButton;
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
    public void handleAddNewArtist(ActionEvent event) {
    }

    @FXML
    public void handleAddNewAlbum(ActionEvent event) {
    }

    @FXML
    public void handleAddNewGenre(ActionEvent event) {
    }

    @FXML
    public void handleInputCompletion(ActionEvent event) {
    }

    @FXML
    public void handleAddSongFile(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
    }
}
