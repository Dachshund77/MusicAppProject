package Controllers;

import Logic.Player.ViewController;
import Logic.Records.AlbumRecord;
import Logic.Records.ArtistRecord;
import Logic.Records.SongRecord;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

/**
 * In this window the user will be able to search for songs, play them or edit them.
 * This scene will take the user either back to {@link MainController} or if he want to edit/add songs to {@link UpdateSongController}.
 */
public class SongListController extends Controller{

    @FXML
    private Button editSongButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private TableView SongTableView;

    /**
     * will set data inside the table view (work in progress),
     * normally we just need to add data to the observableList "song"
     */
    public void initialize() {

        SongRecord songRecord = new SongRecord(1,null,null,"Big Smoke");
        songRecord.getAlbumRecords().add(new AlbumRecord(1,"State Flow"));
        songRecord.getArtistRecords().add(new ArtistRecord(1, "Tash Sultana"));
        songRecord.getGenres().add("Alt-Rock");
        TableView table = new TableView();
        ArrayList<SongRecord> songList = new ArrayList<SongRecord>();
        songList.add(songRecord);
        ObservableList<SongRecord> song = FXCollections.observableArrayList(songList);
        SongTableView.setItems(song);
        TableColumn<SongRecord,String> songCol = new TableColumn<>("Song");
        songCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getSongName()));

        TableColumn<SongRecord,String> albumCol = new TableColumn<>("Album");
        albumCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().FormatAlbumName()));

        TableColumn<SongRecord,String> artistCol = new TableColumn<>("Artist");
        artistCol.setCellValueFactory(param ->  new SimpleStringProperty(param.getValue().FormatArtistName()));

        TableColumn<SongRecord,String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().FormatGenreName()));


        SongTableView.getColumns().setAll(songCol,albumCol,artistCol,genreCol);

    }
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
