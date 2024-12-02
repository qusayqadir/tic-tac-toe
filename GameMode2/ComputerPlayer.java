import java.util.Random; 

public class ComputerPlayer extends Player{

    private int max; 
    private int min; 

    public ComputerPlayer(int min, int max, char symbol){
        super(symbol); 
        this.max = max; 
        this.min = min; 
    }

  
    public int[] getMove(){
        Random random = new Random(); 

        int[] moves = new int[2]; 

        int randomRow = random.nextInt(this.max - this.min + 1 ) + this.min; 
        int randomCol = random.nextInt(this.max - this.min + 1 ) + this.min; 

        moves[0] = randomRow; 
        moves[1] = randomCol; 

        return moves; 
    }

    public int getMin () {return this.min;}
    public int  getMax() {return this.max;}





} 