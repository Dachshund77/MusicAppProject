package Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/Main.fxml"));
        primaryStage.setTitle("Music App");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        //TODO popper close on exist
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void setRoot(Parent parent){
        primaryStage.getScene().setRoot(parent);
    }
}
