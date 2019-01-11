package Controllers;

import Logic.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.File;

/**
 * The controller for the bottom player navigation. From here the user will be able top start, stop, pause, resume the song or navigate the playlist.
 * In addition to that he/she can adjust the volume or skip the song to a specified length.
 */
public class MusicPlayerController extends Controller{

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

    /**
     * Initializer that will set the current {@link MusicPlayerController} to the {@link MusicPlayer} Logic.
     * The MusicPlayer Logic and visuals will not be accessible if not set on initialization.
     * @see MusicPlayer
     */
    public void initialize(){
        MusicPlayer.setMusicPlayerController(this);
    }
    /**
     * Stops the currently playing song by calling {@link MusicPlayer#stopSong()}.
     * This button will be disabled if the input would be nonsensical or invalid.
     * @param event a Button click
     */
    @FXML
    public void handleStop(ActionEvent event) {
        MusicPlayer.stopSong();
    }

    /**
     * Pauses or plays the currently playing by calling {@link MusicPlayer#playPauseSong()} depending on the current state of the mediaPlayer.
     * This button will be disabled if the input would be nonsensical or invalid.
     * @param event a Button click
     */
    @FXML
    public void handlePlayPause(ActionEvent event) {
        MusicPlayer.playPauseSong();
    }

    /**
     * Plays the next song in the que {@link MusicPlayer#loadNextSong()}.
     * This button will be disabled if the input would be nonsensical or the playlist does not have more songs.
     * @param event a Button click
     */
    @FXML
    public void handleNextSong(ActionEvent event) { //TODO shuffle mode might cause a bug.
        MusicPlayer.loadNextSong();
    }

    /**
     * Plays the previous song in the que {@link MusicPlayer#loadPreviousSong()}.
     * This button will be disabled if the input would be nonsensical or the playlist does not have a previous songs.
     * @param event a Button click
     */
    @FXML
    public void handlePreviousSong(ActionEvent event) { //TODO shuffle mode might cause a bug.
        MusicPlayer.loadPreviousSong();
    }

    /**
     * Will Change the scene to {@link MainController}.
     *
     * @param event A button Click
     */
    @FXML
    public void navigateHome(ActionEvent event) {
        //ViewController.MAIN.load();
        File file = new File("C:/Users/Sven/IdeaProjects/MusicAppProject/src/Resources/sample.mp3"); //TODO remove before push to master
        MusicPlayer.loadSong(file); //TODO remove also that

    }

    /**
     * Changes the mode the playlist or song will be played. The modes are:
     * <ul>
     * <li>Loop song, will repeat the same song </li>
     * <li>Loop PlayList, will repeat the same PlayList </li>
     * <li>Shuffle, will play random songs from the given PlayList</li>
     *</ul>
     * The modes will be changed by calling {@link MusicPlayer#changePlayMode()}.
     * @param event a Button click
     */
    @FXML
    public void handleModeChange(ActionEvent event) {
        MusicPlayer.changePlayMode();
    }

    /**
     * Adjust the Volume of the MediaPlayer in the MusicPlayer logic by calling
     * {@link MusicPlayer#setVolume(double)}.
     * @param mouseEvent click or drag on volumne slider
     */
    @FXML
    public void handleVolumeAdjust(MouseEvent mouseEvent) {
        double sliderValue = volumeSlider.getValue();
        double volume = sliderValue / 100;
        MusicPlayer.setVolume(volume);
    }

    /**
     * First part of changing the playBack time of the MediaPlayer in the MusicPlayer Logic.
     * The {@link MusicPlayer#saveStatus()} method will save the status of the mediaPlayer and stop it,
     * so that it wont interfere with the user.
     * @param mouseEvent enter click on timeSlider
     */
    @FXML
    public void handleStartPlaybackAdjust(MouseEvent mouseEvent) {
        MusicPlayer.saveStatus();
    }

    /**
     * Second part of changing the playBack time of the MediaPlayer in the MusicPlayer Logic.
     * The {@link MusicPlayer#setPlaybackTime(double)} will be invoked to set the MediaPlayer to the chosen time
     * and depending on the state of the player when {@link MusicPlayerController#handleStartPlaybackAdjust(MouseEvent)} was invoked
     * possible restarted.
     * @param mouseEvent exist click on timeSlider
     */
    @FXML
    public void handleEndPlaybackTimeAdjust(MouseEvent mouseEvent) {
        MusicPlayer.setPlaybackTime(songTimeSlider.getValue());
    }

    public Button getNextSongButton() {
        return nextSongButton;
    }

    public Button getPlayPauseButton() {
        return playPauseButton;
    }

    public Button getStopSongButton() {
        return stopSongButton;
    }

    public Button getPreviousSongButton() {
        return previousSongButton;
    }

    public Label getSongTimeLabel() {
        return songTimeLabel;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public Slider getSongTimeSlider() {
        return songTimeSlider;
    }

    public Button getModeButton() {
        return modeButton;
    }
}
