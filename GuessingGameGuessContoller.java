/** GuessingGameGuessContoller allow the menu buttons to be responsive on the main.
*
* @author Buqwana Xolisile
* @version 01/09/2024
*  
*/
import javafx.stage.Stage;

public class GuessingGameGuessContoller
{  
    private static Stage primaryStage;
    private static GuessingGameUIController guessingGameUIController;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setGuessingGameUIController(GuessingGameUIController controller) {
        guessingGameUIController = controller;
    }

    public static GuessingGameUIController getGuessingGameUIController() {
        return guessingGameUIController;
    }
}