package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

/**
 * The controller for the bottom player navigation. From here the user will be able top start, stop, pause, resume the song or navigate the playlist.
 * In addition to that he/she can adjust the volume or skip the song to a specified length.
 */
public class MusicPlayerController {

    @FXML
    private Button nextSongButton;
    @FXML
    private Button playPauseButton;
    @FXML
    private Button stopSongButton;
    @FXML
    private Button previousSongButton;
    @FXML
    private Label songTimeLabel;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Slider songTimeSlider;
    @FXML
    private Button modeButton;

    private static MediaPlayer mediaPlayer;
    private static ArrayList<Integer> playList;
    private static double volume = 1.0; // range of 0.0 to 1.0
    private static boolean shuffleModeOn = false;
    private static boolean loopModeOn = false;
    private static int currentSongIndex;

    public void initialize(){
        updateGUI();
    }

    @FXML
    public void handlePreviousSong(ActionEvent event) {
    }

    @FXML
    public void handleStop(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    public void handlePlayPause(ActionEvent event) {
        switch (mediaPlayer.getStatus()) {
            case PLAYING:
                mediaPlayer.pause();
                break;
            default:
                mediaPlayer.play();
                break;
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
        //ViewController.MAIN.load();
        File file = new File("C:/Users/Sven/IdeaProjects/MusicAppProject/src/Resources/sample.mp3"); //TODO remove before push
        loadSong(file); //TODO also that
        mediaPlayer.play();
    }

    @FXML
    public void handleModeChange(ActionEvent event) {
    }

    public void loadSong(File file) {
        //Kill previous song
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        //Load new song
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> handleEndOfMedia());
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> updateGUI());
    }

    private void updateGUI() {
        //Handling the PlayPauseButton and stopButton
        if (mediaPlayer != null){
            MediaPlayer.Status status = mediaPlayer.getStatus();
            System.out.println(status.toString()); //TODO remove at some point
            updatePlayPauseButton(status);
            updateStopButton(status);
        }
        else{
            playPauseButton.setText("Play");
            playPauseButton.setDisable(true);
            stopSongButton.setDisable(true);
        }
        //Handling the nextSong and previousSong Button
        if (playList != null){

        }
        else {
            previousSongButton.setDisable(true);
            nextSongButton.setDisable(true);
        }
    }

    private void updatePlayPauseButton(MediaPlayer.Status status){
        switch (status){
            case READY:
                playPauseButton.setText("play");
                playPauseButton.setDisable(false);
                break;
            case PLAYING:
                playPauseButton.setText("pause");
                playPauseButton.setDisable(false);
                break;
            case STOPPED:
                playPauseButton.setText("play");
                playPauseButton.setDisable(false);
                break;
            case PAUSED:
                playPauseButton.setText("play");
                playPauseButton.setDisable(false);
                break;
            case DISPOSED:
                playPauseButton.setText("play");
                playPauseButton.setDisable(true);
                break;
            case UNKNOWN:
                playPauseButton.setText("play");
                playPauseButton.setDisable(true);
                break;

        }
    }

    private void updateStopButton(MediaPlayer.Status status){
        switch (status){
            case READY:
                stopSongButton.setDisable(true);
                break;
            case PLAYING:
                stopSongButton.setDisable(false);
                break;
            case STOPPED:
                stopSongButton.setDisable(true);
                break;
            case PAUSED:
                stopSongButton.setDisable(false);
                break;
            case DISPOSED:
                stopSongButton.setDisable(true);
                break;
            case UNKNOWN:
                stopSongButton.setDisable(true);
                break;
        }
    }

    private void handleEndOfMedia() {
        System.out.println("End of Media");
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        MusicPlayerController.volume = volume;
    }

    public boolean isShuffleModeOn() {
        return shuffleModeOn;
    }

    public void setShuffeMode(boolean bool) {
        shuffleModeOn = bool;
    }

    public boolean isLoopModeOn() {
        return loopModeOn;
    }

    public void setLoopMode(boolean bool) {
        loopModeOn = bool;
    }

    public ArrayList<Integer> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Integer> newPlayList) {
        playList = newPlayList;
    }


}
