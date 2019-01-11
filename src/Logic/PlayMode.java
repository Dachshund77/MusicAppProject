package Logic;

/**
 * Enum that will be help to determine the way  'end of Media' will handled in {@link MusicPlayer}.
 */
public enum PlayMode {
    NONE("None"),
    SHUFFLE("Shuffle"),
    LOOP_SONG("Loop song"),
    LOOP_PLAYLIST("Loop PlayList");

    private final String name;

    PlayMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
