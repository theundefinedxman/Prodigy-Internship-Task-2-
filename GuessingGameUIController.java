/** GuessingGameUIController which allows the UI to have responsive button features.
*
* @author Buqwana Xolisile
* @version 01/09/2024
*  
*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
//import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;

/** <p>Implements Initializable To intialize the controller</p>
 * 
 */
public class GuessingGameUIController implements Initializable
{
   @FXML
   private Button exitButton;
   @FXML
   private Button helpButton;
   
   @FXML
   private Label generalRemarksLabel;

   @FXML
   private ImageView faceLift;
   
   @FXML
   private Pane slidePane;
   
   private Image closeImage;
   
   /**
    * <p>Required by Initializable interface</p> 
    * <p>Called to initialize a controller after</p>
    * <p>the root element has been processed</p>
    *
    *
    * Intializing two Image objects within this method to make use of URL 
    *
    */
   public void initialize(URL url ,ResourceBundle rb){
   }
   /**
    * <p>getConverterPane() is a Accessor Method</p>
    * <p>which returns a slidePane from the Main Stage scene</p>
    *
    */
   public Pane getSlidePane() {
        return slidePane;
   }
   /**
    * <p>errorAction() is a void Method which performs the following</p>
    * <p>Instantiates the controller,to get control of the Main Stage scene</p>
    * <p>form there inserts the temporay error scene for the length and Mass button</p>
    *
    */
   public void takeAction(ActionEvent event) throws Exception{
      GuessingGameUIController controller =  GuessingGameGuessContoller.getGuessingGameUIController();
      if (controller != null) {
         Pane newSlidePane = controller.getSlidePane();
         newSlidePane.getChildren().clear();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GuessingGameUIGame.fxml"));
         Parent root3 = loader.load();
         newSlidePane.getChildren().add(root3);
      }
   }

   /**
    * <p> helpAction() is a void Method which performs the following</p>
    * <p>Inserts the help scene on the Main Stage scene</p>
    *
    */
   public void helpAction(ActionEvent helpEvent) throws Exception{
      Parent root2 = FXMLLoader.load(getClass().getResource("GuessingGameHelpUI.fxml"));
      slidePane.getChildren().clear();
      Scene scene =  helpButton.getScene();
      root2.translateYProperty().set(scene.getWidth());
      slidePane.getChildren().add(root2);
           
      Timeline timeline = new  Timeline();
      KeyValue fv = new KeyValue(root2.translateYProperty(),0,Interpolator.EASE_IN);
      KeyFrame kf = new KeyFrame(Duration.seconds(0.01),fv);
       
      timeline.getKeyFrames().add(kf);
      timeline.play();
   }
   /**
    * <p>closeAction is a Method which retrieves and closes the stage
    * but pauses the program for a moment to change the Image Viewer image.
    */
   public void closeAction(ActionEvent closeEvent) throws Exception {
      Image closeImage = new Image(getClass().getResourceAsStream("Exit.jpeg")); 
      generalRemarksLabel.setText("Exiting Game.....");
      faceLift.setImage(closeImage);
      //PauseTransition delay = new PauseTransition(Duration.seconds(5));
      //delay.setOnFinished(event -> {
      Stage stage = (Stage) ((Node) closeEvent.getSource()).getScene().getWindow();
      stage.close();
      //});
      //delay.play();
   }
}