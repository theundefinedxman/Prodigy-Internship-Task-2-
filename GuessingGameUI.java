/** GuessingGameUI a UI application that allows to enjoy an intuative guessing game
*
* @author Buqwana Xolisile
* @version 01/09/2024
*  
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
 
public class GuessingGameUI extends Application
{
   /** Loads the fxml file.
   *  To set the Stage.
   *  Then the scene from the root.
   *  
   *  
   */
   public void start(Stage stage) throws Exception {
   
      FXMLLoader loader = new FXMLLoader(getClass().getResource("GuessingGameUI.fxml"));
      Parent root = loader.load();
      
      GuessingGameUIController controller = loader.getController();
      GuessingGameGuessContoller.setPrimaryStage(stage);
      GuessingGameGuessContoller.setGuessingGameUIController(controller);
      
      Image icon = new Image("GuessingGame.png");
      
      stage.getIcons().add(icon);
      Scene scene = new Scene(root,700,500);
      stage.setTitle("Guessing Game");
      stage.setScene(scene);
      stage.show();
   }
   public static void main(String[] args){
      launch(args);
   }
}