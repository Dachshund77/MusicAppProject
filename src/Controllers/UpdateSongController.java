package Controllers;

import Logic.Player.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * In this Scene the user will have the possibility to edit or add a Song.
 * If the user wants to Add a new Artist, Genre or Album he will need to use {@link UpdateArtistController}, {@link UpdateGenreController} or {@link UpdateAlbumController}.
 */
public class UpdateSongController extends Controller{

    @FXML
    private Button addSongButton;
    @FXML
    private Button addArtistButton;
    @FXML
    private Button addAlbumButton;
    @FXML
    private Button addGenreButton;
    @FXML
    private TextField songNameTextField;
    @FXML
    private MenuButton artistMenuButton;
    @FXML
    private MenuButton albumMenuButton;
    @FXML
    private MenuButton genreMenuButton;

    public void initialize(){

    }

    private void populateArtistMenuButton(){

    }

    private void populateAlbumMenuButton(){

    }

    private void populateGenreMenuButton(){

    }

    @FXML
    public void handleAddNewArtist(ActionEvent event) {
        ViewController.UPDATE_ARTIST.load();
    }

    @FXML
    public void handleAddNewAlbum(ActionEvent event) {
        ViewController.UPDATE_ALBUM.load();
    }

    @FXML
    public void handleAddNewGenre(ActionEvent event) {
        ViewController.UPDATE_GENRE.load();
    }

    @FXML
    public void handleInputCompletion(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.SONGLIST.load();
    }

    @FXML
    public void handleNewArtist(ActionEvent event) {
    }

    @FXML
    public void handleNewAlbum(ActionEvent event) {
    }

    @FXML
    public void handleNewGenre(ActionEvent event) {
    }

    @FXML
    public void handleAddAlbumToSong(ActionEvent event) {
    }

    @FXML
    public void handleAddArtistToSong(ActionEvent event) {
    }

    @FXML
    public void handleAddGenreToSong(ActionEvent event) {
    }

    @FXML
    public void handleAddSongFile(ActionEvent event) {

    }
}
