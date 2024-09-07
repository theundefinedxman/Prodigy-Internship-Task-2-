/** GuessingGameGuessContoller allow access to controls of the game Pane
*
* @author Buqwana Xolisile
* @version 01/09/2024
*  
*/
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
public class GuessingGameUIGameController
{
    @FXML
    private Label generalRemarkLabel;
    @FXML
    private Label computerLabel;
    
    @FXML
    private TextField numberLabel;

    @FXML
    private ImageView faceLift;
    
    @FXML
    private Button guessButton;
    @FXML
    private Button newLabel;

    
    final RandomController rc = new RandomController();
    int Round = 1;

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

    public Label getGeneralRemarkLabel() {
        return generalRemarkLabel;
    }
    
    public String getGuessedNumber()
    {
       return numberLabel.getText(); 
    }
    
    public String checkGuessedNumber(){
        try{
            if((Integer.parseInt(this.getGuessedNumber())>=0)&&(Integer.parseInt(this.getGuessedNumber())<=10))
                return "InBound";
            else 
                return "Out of Bound";
            }
        catch(Exception e){
            generalRemarkLabel.setText("Please Enter a number");   
        }
            return "";
    }
    
    public void  guessAction(ActionEvent gameEvent)throws Exception{
        if(this.checkGuessedNumber().equals("InBound")){
            if(Round<3){  
               int c = rc.getRandomNumber();
               computerLabel.setText(String.valueOf(c));
               rc.addUserNumber(Integer.parseInt(this.getGuessedNumber()));
               rc.addComputerNumber(c);
               generalRemarkLabel.setText(rc.generalRemarks(c,(Integer.parseInt(this.getGuessedNumber()))));
               rc.getUserNumber();
               rc.getComputerNumber();
               System.out.println("Round "+Round);
               Round++;
               if(rc.generalRemarks(c,(Integer.parseInt(this.getGuessedNumber()))).equals("Too Low")){
                   Image reactionImage1 = new Image(getClass().getResourceAsStream("tooLowEmoji.jpeg"));
                   Image reactionImage2 = new Image(getClass().getResourceAsStream("tooLowEmoji1.jpeg"));
                   Image[] reactionImages = {reactionImage1,reactionImage1};
                   Random r = new Random();
                   faceLift.setImage(reactionImages[r.nextInt(2)]);
               } 
               else if(rc.generalRemarks(c,(Integer.parseInt(this.getGuessedNumber()))).equals("Too High")){
                   Image reactionImag1 = new Image(getClass().getResourceAsStream("tooHighEmoji2.jpeg"));
                   Image reactionImag2 = new Image(getClass().getResourceAsStream("tooHighEmoji1.jpeg"));
                   Image[] reactionImags = {reactionImag1,reactionImag1};
                   Random x = new Random();
                   faceLift.setImage(reactionImags[x.nextInt(2)]);
               } 
               else if(rc.generalRemarks(c,(Integer.parseInt(this.getGuessedNumber()))).equals("Your Good")){
                   Image reactionImae = new Image(getClass().getResourceAsStream("correctEmoji.jpeg"));
                   Image reactionIma2 = new Image(getClass().getResourceAsStream("correctEmoji2.jpeg"));
                   Image[] reactionImas = {reactionImae,reactionIma2};
                   Random y = new Random();
                   faceLift.setImage(reactionImas[y.nextInt(2)]);
               } 
             }
             else if (Round==3){
                  int c = rc.getRandomNumber();
                  computerLabel.setText(String.valueOf(c));
                  rc.addUserNumber(Integer.parseInt(this.getGuessedNumber()));
                  rc.addComputerNumber(c);
                  generalRemarkLabel.setText(rc.generalRemarks(c,(Integer.parseInt(this.getGuessedNumber()))));
                  rc.getUserNumber();
                  rc.getComputerNumber();
                  rc.storePoints();
                  
                  GuessingGameUIController resultController = GuessingGameGuessContoller.getGuessingGameUIController();
                   if(resultController  != null){
                       Pane slidePane =  resultController.getSlidePane();
                       slidePane.getChildren().clear();
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("GuessingGameResultsUI.fxml"));
                       Parent root3 = loader.load();
                       GuessingGameUINewGameController newController = loader.getController();
                       newController.setResults(rc.userNumberPoints);
                       newController.setResultc(rc.computerNumberPoints); 
                       newController.setOutcome(rc.getWinner());
                       slidePane.getChildren().add(root3);
                       System.out.println("Round "+Round);
                    } 
                    else{
                        System.out.println("Controller is not initialized.");// For Debugging Purposes
                    } 
                }
          }
         else if(this.checkGuessedNumber().equals("Out of Bound")){
            generalRemarkLabel.setText("Range 0 - 10");
            numberLabel.clear();
            computerLabel.setText("");
            Round = 1;
         }
    }    
}
    