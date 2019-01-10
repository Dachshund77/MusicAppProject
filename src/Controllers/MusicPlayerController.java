package Controllers;

import Logic.MusicPlayer;
import Logic.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.io.File;

/**
 * The controller for the bottom player navigation. From here the user will be able top start, stop, pause, resume the song or navigate the playlist.
 * In addition to that he/she can adjust the volume or skip the song to a specified length.
 */
public class MusicPlayerController {

    @FXML
    public Button nextSongButton;
    @FXML
    public Button playPauseButton;
    @FXML
    public Button stopSongButton;
    @FXML
    public Button previousSongButton;
    @FXML
    public CheckBox loopCheckBox;
    @FXML
    public CheckBox shuffleCheckBox;
    @FXML
    public Label songTimeLabel;
    @FXML
    public Slider volumeSlider;
    @FXML
    public Slider songTimeSlider;

    public void initialize() {
        File file = new File("C:/Users/Sven/IdeaProjects/MusicAppProject/src/Resources/sample.mp3"); //TODO remove before push
        MusicPlayer.loadSong(file);



    }

    @FXML
    public void handlePreviousSong(ActionEvent event) {
    }

    @FXML
    public void handleStop(ActionEvent event) {
        MusicPlayer.stopSong();
    }

    @FXML
    public void handlePlayPause(ActionEvent event) {
        switch (MusicPlayer.getStatus()) {
            case PLAYING:
                MusicPlayer.pauseSong();
                break;
            case PAUSED:
                MusicPlayer.playSong();
                break;
            default:
                MusicPlayer.playSong();
        }

    }

    @FXML
    public void handleNextSong(ActionEvent event) {
    }

    /**
     * Will Change the scene to {@link MainController}.
     *
     * @param event A button Click
     */
    @FXML
    public void navigateHome(ActionEvent event) {
        ViewController.MAIN.load();
    }
}
