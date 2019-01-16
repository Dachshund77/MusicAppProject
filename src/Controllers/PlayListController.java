package Controllers;

import Logic.Player.ViewController;
import Logic.Records.PlayListRecord;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

/**
 * This scene will be used to find a playlist and start it.
 * The user can either go back to {@link MainController} or if he/she want to edit a playlist go
 * to {@link UpdatePlayListController}.
 */
public class PlayListController extends Controller{

    @FXML
    private Button editPlayListButton;
    @FXML
    private Button deletePlayListButton;
    @FXML
    private TableView playListTableView;

    public void initialize(){
        PlayListRecord playListRecord = new PlayListRecord(1,"PlayList1");
        TableView table = new TableView();
        ArrayList<PlayListRecord> playListName = new ArrayList<PlayListRecord>();
        playListName.add(playListRecord);
        ObservableList<PlayListRecord> song = FXCollections.observableArrayList(playListName);
        playListTableView.setItems(song);
        TableColumn<PlayListRecord,String> playListCol = new TableColumn<>("PlayList");
        playListCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        playListTableView.getColumns().setAll(playListCol);
    }

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
