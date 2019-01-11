package Controllers;

/**
 * Interface to allow polymorphism between this applications Controllers.
 */
public interface Controllers {

    /**
     * Method that will load the Controller with needed information.
     * This method can be used to pass information from one Controller to another.
     * <br><br>
     * <p>
     * <font color="Red">
     * IMPORTANT:
     * </font>
     * This method need to be overridden to work correctly.
     * </p>
     * Consult {@link Logic.ViewController} Enum class if custom values are needed.
     * @param string String passed to the new Controller
     * @see Controller
     */
    void initValues(String string);
}
