import java.util.Scanner; 


public class HumanPlayer extends Player {

    
    public HumanPlayer(char symbol){

        super(symbol); 
    
    }

    public int[] getMove() {

        Scanner scanner =  new Scanner(System.in); 

        String playerLocation = scanner.nextLine();
        String[] gridLocation = playerLocation.split(","); 
        int row = Integer.parseInt(gridLocation[0]);
        int col = Integer.parseInt(gridLocation[1]); 

        int[] moves = new int[2]; 

        moves[0] = row; 
        moves[1] = col; 

        return moves; 


    }


}