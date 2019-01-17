package Controllers;

import Database.DbHelper;
import Logic.Player.ViewController;
import Logic.Records.AlbumRecord;
import Logic.Records.ArtistRecord;
import Logic.Records.SongRecord;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * In this Scene the user will have the possibility to edit or add a Song.
 * If the user wants to Add a new Artist, Genre or Album he will need to use {@link UpdateArtistController}, {@link UpdateGenreController} or {@link UpdateAlbumController}.
 */
public class UpdateSongController extends Controller{

    @FXML
    private ChoiceBox<AlbumRecord> albumChoiceBox;
    @FXML
    private ChoiceBox<String> genreChoiceBox;
    @FXML
    private ChoiceBox<ArtistRecord> artistChoiceBox;
    @FXML
    private Button completeButton;
    @FXML
    private Button removeArtistButton;
    @FXML
    private Button removeAlbumButton;
    @FXML
    private Button removeGenreButton;
    @FXML
    private Button addSongButton;
    @FXML
    private TextField songNameTextField;

    private static SongRecord songRecord;



    public void initialize(){
        //For testing purposes
        ArrayList<SongRecord> songRecords = DbHelper.findAndGetSongRecords("ASong",null,null,null);
        songRecord = songRecords.get(0);
        populateArtistChoiceBox();

    }
    // Artist  stuff

    private void populateArtistChoiceBox(){
        HashSet<ArtistRecord> artistRecords = songRecord.getArtistRecords();
        ObservableList<ArtistRecord> artistRecordObservableList = FXCollections.observableArrayList(artistRecords);
        artistChoiceBox.getItems().setAll(artistRecordObservableList);
    }

    @FXML
    public void handleEditArtist(ActionEvent event) {
        ArtistRecord testRecord = artistChoiceBox.getValue();
        songRecord.getArtistRecords().remove(testRecord);
        populateArtistChoiceBox();

    }

    @FXML
    public void handleRemoveArtistFromSong(ActionEvent event) {
    }


    //Album Stuff

    private void populateAlbumChoiceBox(){
        HashSet<AlbumRecord> albumRecords = songRecord.getAlbumRecords();
        ObservableList<AlbumRecord> albumRecordObservableList = FXCollections.observableArrayList(albumRecords);
        albumChoiceBox.getItems().setAll(albumRecordObservableList);
    }

    @FXML
    public void handleEditAlbum(ActionEvent event) {
    }

    @FXML
    public void handleRemoveAlbumFromSong(ActionEvent event) {
    }

    // Genre Stuff


    private void populateGenreChoiceBox(){
        HashSet<String> genres = songRecord.getGenres();
        ObservableList<String> genresObservableList = FXCollections.observableArrayList(genres);
        genreChoiceBox.getItems().setAll(genresObservableList);
    }

    @FXML
    public void handleEditGenre(ActionEvent event) {
    }

    @FXML
    public void handleRemoveGenreFromSong(ActionEvent event) {
    }


    //SongFile

    @FXML
    public void handleAddSongFile(ActionEvent event) {

    }

    //Navigation

    @FXML
    public void handleInputCompletion(ActionEvent event) {
    }

    @FXML
    public void navigateBack(ActionEvent event) {
        ViewController.SONGLIST.load();
    }

    public void test(ActionEvent event) {
        System.out.println("Test");
    }
}
