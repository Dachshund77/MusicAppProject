package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

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
    private static boolean loopSongOn = false;
    private static boolean loopPlayListOn = false;
    private static Integer currentSongIndex;

    public void initialize() {
        updateGUI();
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
        loadSong(currentSongIndex++);
    }

    @FXML
    public void handlePreviousSong(ActionEvent event) {
        loadSong(currentSongIndex--);
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
        loadSong(file); //TODO remove also that
        mediaPlayer.play();
    }

    @FXML
    public void handleModeChange(ActionEvent event) {
        switch (modeButton.getText()) {
            case "None":
                modeButton.setText("Loop Song");
                loopSongOn = true;
                break;
            case "Loop Song":
                modeButton.setText("Loop PlayList");
                loopSongOn = false;
                loopPlayListOn = true;
                break;
            case "Loop PlayList":
                modeButton.setText("Shuffle");
                loopPlayListOn = false;
                shuffleModeOn = true;
                break;
            case "Shuffle":
                modeButton.setText("None");
                shuffleModeOn = false;
                break;
        }
    }

    @FXML
    public void handleVolumeAdjust(MouseEvent mouseEvent) {
        double sliderValue = volumeSlider.getValue();
        volume = sliderValue / 100;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }

    }

    public void loadSong() {
        loadSong(0);
    }

    public void loadSong(int songID) {
        //We need to set and currenSongId Here
    }

    public void loadSong(File file) { //TODO we would like to get a songFile via songID since we store and need the id in this calls anyway
        //Kill previous song
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        //Load new song
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(this::handleEndOfMedia);
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> updateGUI());
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> updateTimeLabel());
    }

    private void updateGUI() {
        //Handling the PlayPauseButton and stopButton
        if (mediaPlayer != null) {
            MediaPlayer.Status status = mediaPlayer.getStatus();
            System.out.println(status.toString()); //TODO remove at some point
            updatePlayPauseButton(status);
            updateStopButton(status);
        } else {
            playPauseButton.setText("Play");
            playPauseButton.setDisable(true);
            stopSongButton.setDisable(true);
        }
        //Handling the nextSong and previousSong Button
        if (playList != null && currentSongIndex != null) {
            updateNextSongButton();
            updatePreviousSongButton();
        } else {
            previousSongButton.setDisable(true);
            nextSongButton.setDisable(true);
        }
        //Handling the modeButton
        updateModeButton();
        //Handling VolumeSlider
        updateVolumneSlider();
        //Handle the time label and slider

    }

    private void updatePlayPauseButton(MediaPlayer.Status status) {
        switch (status) {
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

    private void updateStopButton(MediaPlayer.Status status) {
        switch (status) {
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

    private void updateNextSongButton() {
        if (hasNextSong()) {
            nextSongButton.setDisable(false);
        } else {
            nextSongButton.setDisable(true);
        }
    }

    private void updatePreviousSongButton() {
        if (hasPreviousSong()) {
            previousSongButton.setDisable(false);
        } else {
            previousSongButton.setDisable(true);
        }
    }

    private void updateModeButton() {
        if (loopSongOn) {
            modeButton.setText("Loop Song");
        } else if (loopPlayListOn) {
            modeButton.setText("Loop PlayList");
        } else if (shuffleModeOn) {
            modeButton.setText("Shuffle");
        } else {
            modeButton.setText("None");
        }
    }

    private void updateVolumneSlider() {
        volumeSlider.adjustValue(volume * 100);
    }

    private void updateTimeLabel() {
        System.out.println("Test");

        int seconds = (int) mediaPlayer.getCurrentTime().toSeconds();
        String time = String.format("%02d:%02d", seconds / 60, seconds % 60);
        System.out.println(time);
        songTimeLabel.setText(time);


    }

    private void handleEndOfMedia() {
        if (shuffleModeOn) {
            loadSong(new Random().nextInt(playList.size()));
        } else if (loopSongOn) {
            loadSong(currentSongIndex);
        } else if (!hasNextSong() && loopPlayListOn) {
            loadSong();
        } else {
            loadSong(currentSongIndex++);
        }
    }

    private boolean hasNextSong() {
        boolean returnBoolean = true;
        if (currentSongIndex == playList.size() - 1) {
            returnBoolean = false;
        }
        return returnBoolean;
    }

    private boolean hasPreviousSong() {
        boolean returnBoolean = true;
        if (currentSongIndex == 0) {
            returnBoolean = false;
        }
        return returnBoolean;
    }

    public ArrayList<Integer> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Integer> newPlayList) {
        playList = newPlayList;
        updateGUI();
    }

}
