package Logic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * Class that will be in charge of storing and handling all importing operations for the music application.
 * Since we change the scene we need to preserve the information between scenes, hence we use this class.
 */
public class MusicPlayer {//TODO there some weird issue that makes the player crash......... no idea why

    private static MediaPlayer mediaPlayer;
    private static double volume;

    public static void loadSong(File file){
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
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
}
