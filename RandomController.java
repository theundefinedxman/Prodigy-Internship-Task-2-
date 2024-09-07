import java.util.Random;

public class RandomController
{
    int[] userNumber = new int[3];
    int[] computerNumber = new int[3];
    int[] userNumberPoints = new int[3];
    int[] computerNumberPoints = new int[3];
    
    private int totalpoints;
    private int totalpointsc;
    private int  round;
    private int  roundc;
    
    public RandomController()
    {
      this.totalpoints = 0;
      this.totalpointsc = 0;
      this.round = 0;
      this.roundc = 0;
    } 
    public int getRandomNumber()
    {
      Random random = new Random();
      return  random.nextInt(11);  
    }
    public void addUserNumber(int num)
    {
       userNumber[round] = num;
       round++; 
    }
    public void addComputerNumber(int num)
    {
       computerNumber[roundc] = num; 
       roundc++;
    }
    public void getUserNumber()
    {
        for(int i = 0; i<3 ; i++)
        {
           System.out.println(i+" un "+userNumber[i]);
        }
    }
    public void getComputerNumber()
    {
        for(int i = 0; i<3 ; i++)
        {
           System.out.println(i+" cn "+computerNumber[i]);
        }
    }
    public int getComputerPoints()
    {   
        int  totC = 0;
        for(int i = 0; i<3 ; i++)
        {
           totC += computerNumberPoints[i];
        }

        return totC;
    }
    public int getUserPoints()
    {
        int totU = 0;
        for(int i = 0; i<3 ; i++)
        {
           totU += userNumberPoints[i];
        } 

        return totU;
    }
    public void storePoints()
    {
        for(int i = 0; i<3 ; i++)
        {
            if(this.compareNumber(userNumber[i],computerNumber[i])<0){
                userNumberPoints[i] = 0;
                computerNumberPoints[i] = 1;
            }
            else if(this.compareNumber(userNumber[i],computerNumber[i])>0){
                userNumberPoints[i] = 0;
                computerNumberPoints[i] = 1;
            }
            else{
               userNumberPoints[i] = 1;
               computerNumberPoints[i] = 0;
            }
        }
       
    }
    public String generalRemarks(int C,int U)
    {
       if(this.compareNumber(U,C)<0)
          return "Too Low";
       else if(this.compareNumber(U,C)>0)
          return "Too High";
       else
          return "Your Good";
    }
    public int getTotalPoints(){
      return this.totalpoints;
    }
    public int getTotalPointsc(){
      return this.totalpointsc;
    }

    public String getWinner()
    { 
        if(this.getUserPoints()>this.getComputerPoints()){
            return "Win!!!";
        }
        else if(this.getUserPoints()<this.getComputerPoints()){
           return "Lose!!!";
        }
        else{
           return "Draw"; 
        }
    }
    public int compareNumber(int UserNumber,int ComputerNumber)
    {
        return  UserNumber-ComputerNumber;
    }
}