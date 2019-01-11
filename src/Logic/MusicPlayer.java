package Logic;

import Controllers.MusicPlayerController;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * MusicPlayer Logic that is in charge of managing a MediaPlayer.
 * This class will be the main manager of the MediaPlayer.
 * <br><br>
 * <p>
 * <font color='red'>
 * IMPORTANT:
 * </font>
 * <br>
 * in order for this Class to work with a Controller it must be set with {@link MusicPlayer#setMusicPlayerController(MusicPlayerController)}.
 * </p>
 */
public class MusicPlayer {

    private static MediaPlayer mediaPlayer;
    private static ArrayList<Integer> playList;
    private static double volume = 1.0; // range of 0.0 to 1.0
    private static boolean shuffleModeOn = false;
    private static boolean loopSongOn = false;
    private static boolean loopPlayListOn = false;
    private static Integer currentSongIndex;
    private static MusicPlayerController musicPlayerController;
    private static MediaPlayer.Status mediaPlayerStatus; //Needed for the playBack adjust

    /**
     * Loads the first song of a playlist.
     * Note that the song will not be automatically played.
     */
    public static void loadSong() {
        loadSong(0);
    }

    /**
     * Loads a song specified by the singID.
     * Note that the song will not be automatic played.
     * @param songID songID of the song in theDatabase
     */
    public static void loadSong(int songID) {
        //We need to set and currenSongId Here
    }

    /**
     * Loads a song by file.
     * This method enlist an number of listeners that will keep track of important events.
     * Note that the song will not ne automatic played.
     * @param file
     */
    public static void loadSong(File file) { //TODO we would like to get a songFile via songID since we store and need the id in this calls anyway. Also some specifics how the use flow should work need to be discussed
        //Kill previous song
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        //Load new song
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);
        mediaPlayer.setOnEndOfMedia(MusicPlayer::handleEndOfMedia);
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> updateGUI());
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            updateTimeLabel();
            updateTimeSlider();
        });
    }

    /**
     * Loads the next song of the Playlist.
     */
    public static void loadNextSong() {
        loadSong(currentSongIndex++);
    }

    /**
     * Loads the previous song of the PlayList
     */
    public static void loadPreviousSong() {
        loadSong(currentSongIndex--);
    }

    /**
     * Stops the current song of the MediaPlayer.
     */
    public static void stopSong() {
        mediaPlayer.stop();
    }

    /**
     * Plays the current song of the MediaPlayer
     */
    public static void playSong() {
        mediaPlayer.play();
    }

    /**
     * Will pause if the song is playing and play if the song is paused.
     */
    public static void playPauseSong() {
        switch (mediaPlayer.getStatus()) {
            case PLAYING:
                mediaPlayer.pause();
                break;
            default:
                mediaPlayer.play();
                break;
        }
    }

    /**
     * manager to update the complete UI.
     * Note that {@link MusicPlayer#updateTimeLabel()} and {@link MusicPlayer#updateTimeSlider()} will be called
     * via actionListener and can always be considered up to date.
     */
    private static void updateGUI() {
        //Getting values
        Button playPauseButton = musicPlayerController.getPlayPauseButton();
        Button stopSongButton = musicPlayerController.getStopSongButton();
        Button previousSongButton = musicPlayerController.getPreviousSongButton();
        Button nextSongButton = musicPlayerController.getNextSongButton();
        //Handling the PlayPauseButton and stopButton
        if (mediaPlayer != null) {
            MediaPlayer.Status status = mediaPlayer.getStatus();
            System.out.println(status.toString()); //TODO remove before master push
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

    }

    /**
     * Sets the for the PlayPauseButton in the {@link MusicPlayerController} depending on the
     * status of the MediaPlayer.
     * @param status Current State of the MediaPlayer
     */
    private static void updatePlayPauseButton(MediaPlayer.Status status) {
        Button playPauseButton = musicPlayerController.getPlayPauseButton();
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

    /**
     * Sets the for the stopSongButton in the {@link MusicPlayerController} depending on the
     * status of the MediaPlayer.
     * @param status Current State of the MediaPlayer
     */
    private static void updateStopButton(MediaPlayer.Status status) {
        Button stopSongButton = musicPlayerController.getStopSongButton();
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

    /**
     * Enables or disables the nextSongButton in the {@link MusicPlayerController} depending on the
     * status of the MediaPlayer. This button will be disabled if the playList has no more songs.
     */
    private static void updateNextSongButton() {
        Button nextSongButton = musicPlayerController.getNextSongButton();
        if (hasNextSong()) {
            nextSongButton.setDisable(false);
        } else {
            nextSongButton.setDisable(true);
        }
    }

    /**
     * Enables or disables the previousSongButton in the {@link MusicPlayerController} depending on the
     * status of the MediaPlayer. This button will be disabled if the playList has no previous songs.
     */
    private static void updatePreviousSongButton() {
        Button previousSongButton = musicPlayerController.getPreviousSongButton();
        if (hasPreviousSong()) {
            previousSongButton.setDisable(false);
        } else {
            previousSongButton.setDisable(true);
        }
    }

    /**
     * Sets the text of the modeButton in the {@link MusicPlayerController} depending on what mod is active.
     */
    private static void updateModeButton() {
        Button modeButton = musicPlayerController.getModeButton();
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

    /**
     * Sets the position of the volumne slider in the {@link MusicPlayerController}.
     */
    private static void updateVolumneSlider() {
        /*The volumne field will be 0.0 to 1.0
        The slider has a range of 0 to 100
         */
        musicPlayerController.getVolumeSlider().setValue(volume * 100);
    }

    /**
     * Sets the timeLabel in the {@link MusicPlayerController}, depending on the current playBack time.
     */
    private static void updateTimeLabel() {
        int seconds = (int) mediaPlayer.getCurrentTime().toSeconds();
        String time = String.format("%02d:%02d", seconds / 60, seconds % 60); //Works like system.out.printf
        musicPlayerController.getSongTimeLabel().setText(time);
    }

    /**
     * sets the position of the time slider in the {@link MusicPlayerController} depending on the current playBack time.
     */
    private static void updateTimeSlider() {
        Slider songTimeSlider = musicPlayerController.getSongTimeSlider();
        double currentTime = mediaPlayer.getCurrentTime().toSeconds();
        double endTime = mediaPlayer.getStopTime().toSeconds();
        double value = currentTime / endTime;
        songTimeSlider.setValue(value * 100); //Slider goes from 0 to 100

    }

    /**
     * Invoked at the end of a song and will decide how the player proceeds, depending on current mode.
     * The modes are:
     * <ul>
     * <li>Loop song, will repeat the same song </li>
     * <li>Loop PlayList, will repeat the same PlayList </li>
     * <li>Shuffle, will play random songs from the given PlayList</li>
     * </ul>
     * If no mode is selected and there are more songs the player will just load the next song.
     */
    private static void handleEndOfMedia() {
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

    /**
     * Helper method that checks the playlist if there are more song.
     * @return true if there are more songs
     */
    private static boolean hasNextSong() {
        boolean returnBoolean = true;
        if (currentSongIndex == playList.size() - 1) {
            returnBoolean = false;
        }
        return returnBoolean;
    }

    /**
     * Helper method that checks the playlist if there is a previous song.
     * @return true if there is a previous songs
     */
    private static boolean hasPreviousSong() {
        boolean returnBoolean = true;
        if (currentSongIndex == 0) {
            returnBoolean = false;
        }
        return returnBoolean;
    }

    /**
     * Saves the current status of the MediaPlayer.
     * Note that this method also pause the MediaPlayer.
     * This method will used to set the PlayBack time.
     * @see MusicPlayerController#handleStartPlaybackAdjust(MouseEvent)
     */
    public static void saveStatus() {
        mediaPlayerStatus = mediaPlayer.getStatus();
        mediaPlayer.pause();
    }

    /**
     * Plays the MediaPlayer, depending on the Status field.
     * @see MusicPlayer#setPlaybackTime(double)
     */
    private static void resumeStatus() {
        switch (mediaPlayerStatus) {
            case PLAYING:
                mediaPlayer.play();
                break;
            default:
                break;
        }
    }

    /**
     * Sets the current MediaPlayer to a new PlayBack time
     * @param value double from 0 to 100
     */
    public static void setPlaybackTime(double value) {
        double endTime = mediaPlayer.getStopTime().toSeconds();
        double newTime = endTime * (value / 100);
        mediaPlayer.seek(Duration.seconds(newTime));
        resumeStatus();
    }

    /**
     * Sets the volumne the song played at.
     * @param value double from 0 to 1
     */
    public static void setVolume(double value) {
        volume = value;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(value);
        }
    }

    /**
     * manages what mode the player will be played at.
     * This method will also update the ModeButton in the {@link MusicPlayerController}.
     */
    public static void changePlayMode() {
        Button modeButton = musicPlayerController.getModeButton();
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

    public static ArrayList<Integer> getPlayList() {
        return playList;
    }

    public static void setPlayList(ArrayList<Integer> newPlayList) {
        playList = newPlayList;
        updateGUI();
    }

    /**
     * Sets the controller references in MusicPlayer, and enables visual feedback and user interaction with the MusicPlayer Logic.
     * @param musicPlayerController MusicPlayerController we want to interact with
     */
    public static void setMusicPlayerController(MusicPlayerController musicPlayerController) {
        MusicPlayer.musicPlayerController = musicPlayerController;
        updateGUI();
    }
}
