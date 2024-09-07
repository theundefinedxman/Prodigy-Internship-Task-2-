/** GuessingGameUINewGameContoller allows for a new game once thew results have been displayed  
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
 
public class GuessingGameUINewGameController{
   @FXML
   private Label yourResult1Label;
   @FXML
   private Label yourResult2Label;
   @FXML
   private Label yourResult3Label;
   @FXML
   private Label computerResult1Label;
   @FXML
   private Label computerResult2Label;
   @FXML
   private Label computerResult3Label;
   @FXML
   private Label yourResultsLabel;
   @FXML
   private Label computerResultsLabel;
   @FXML
   private Label commentResultsLabel;

   @FXML
   private ImageView outcomeImage;
   
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
   
    public void setResults(int[] points) {
      for(int i = 0; i<3;i++){
         if(i==0)
             yourResult1Label.setText(String.valueOf(points[i]));
         else if(i==1)
             yourResult2Label.setText(String.valueOf(points[i]));
         else if(i==2)
             yourResult3Label.setText(String.valueOf(points[i]));
      }
      yourResultsLabel.setText(String.valueOf(points[0]+points[1]+points[2]));
    }
    public void setResultc(int[] points) {
      for(int i = 0; i<3;i++){
         if(i==0)
             computerResult1Label.setText(String.valueOf(points[i]));
         else if(i==1)
             computerResult2Label.setText(String.valueOf(points[i]));
         else if(i==2)
             computerResult3Label.setText(String.valueOf(points[i]));
      }
      computerResultsLabel.setText(String.valueOf(points[0]+points[1]+points[2]));

    }
    public void setAllResult(int points,int pointsc) {
         yourResultsLabel.setText(String.valueOf(points));
         computerResultsLabel.setText(String.valueOf(pointsc));
    }
    public void setOutcome(String outcome){
       if(outcome.equals("Win!!!")){
          commentResultsLabel.setText(outcome);
          Image winImage = new Image(getClass().getResourceAsStream("Win.jpeg"));
          outcomeImage.setImage(winImage);
       }
       else if(outcome.equals("Lose!!!")){
          commentResultsLabel.setText(outcome);
          Image loseImage = new Image(getClass().getResourceAsStream("Lose.jpeg"));
          outcomeImage.setImage(loseImage);
       }
       else if(outcome.equals("Draw")){   // Highly unlikely
          commentResultsLabel.setText(outcome);
          Image drawImage = new Image(getClass().getResourceAsStream("Draw.jpeg"));
          outcomeImage.setImage(drawImage);
       }
    }
    public void newAction(ActionEvent newEvent)throws Exception{
        System.out.println("Iam called but No response");
        GuessingGameUIController guessingGameUIController = new GuessingGameUIController();
        guessingGameUIController.takeAction(newEvent);
    }
}