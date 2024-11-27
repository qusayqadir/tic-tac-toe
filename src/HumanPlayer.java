
public class HumanPlayer extends Player {

    
    public HumanPlayer(char symbol){

        super(symbol); 
    
    }

    public int[] getComputerMove() {

        int[] error = new int[2]; 
        error[0] = 10000; 
        error[1] = 10000; 

        return error; 
    }


}