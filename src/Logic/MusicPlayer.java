package Logic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;

/**
 * Class that will be in charge of storing and handling all importing operations for the music application.
 * Since we change the scene we need to preserve the information between scenes, hence we use this class.
 */
public class MusicPlayer {//TODO there some weird issue that makes the player crash......... no idea why

    private static MediaPlayer mediaPlayer;
    private static ArrayList<Integer> playList;
    private static double volume = 1.0; // range of 0.0 to 1.0
    private static boolean shuffleModeOn = false;
    private static boolean loopModeOn = false;

    public static void loadSong(File file){
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.toString()));
    }

    public static void playSong(){
        mediaPlayer.play();
    }

    public static void pauseSong(){
        mediaPlayer.pause();
    }

    public static void stopSong(){
        mediaPlayer.stop();
    }

    public static MediaPlayer.Status getStatus(){
        return mediaPlayer.getStatus();
    }

    public static double getVolume(){
        return volume;
    }

    public static void setVolume(double volume){
        MusicPlayer.volume = volume;
    }

    public static boolean isShuffleModeOn(){
        return shuffleModeOn;
    }

    public static void setShuffeMode(boolean bool){
        shuffleModeOn = bool;
    }

    public static boolean isLoopModeOn(){
        return loopModeOn;
    }

    public static void setLoopMode(boolean bool){
        loopModeOn = bool;
    }


}
