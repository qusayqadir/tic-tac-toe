
import java.util.Scanner; 

public class CustomGame extends Game{

    private int numForWin;


    public CustomGame() {
        if (this.gameMode == 0) { // Check if gameMode is uninitialized (default value 0)
            int tempGameMode = setGameMode(); 
            this.gameMode = tempGameMode;
        }

        if (getGameMode() == 4 || getGameMode() == 5) {
            customGameSetup();
        } else {
            standardGameSetup(this.gameMode);
        }
    }

    private void standardGameSetup(int gameMode) {
        if (this.board == null) {
            this.boardSize = 3; 
            this.board = new Board(this.boardSize);
        }


        if (gameMode == 1 ) {
            this.player1 = new HumanPlayer ('X'); 
            this.player2 = new HumanPlayer ('O'); 
        }
        else if (gameMode == 2 ) {
            this.player1 = new HumanPlayer ('X'); 
            this.player2 = new SmartComputerPlayer(1,this.boardSize,'O',this.board); 
        }
        else if (gameMode == 3 ) {
            this.player1 = new SmartComputerPlayer(1,this.boardSize, 'X', this.board); 
            this.player2 = new SmartComputerPlayer(1, this.boardSize, 'O', this.board); 
        }
    }

    public void customGameSetup(){
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Create your own N*N board 3 <= N <= 20"); 
        int tempBoardSize = scanner.nextInt(); 
        while(tempBoardSize > 20 || tempBoardSize < 3 ) {
            System.out.println("Enter in a size in the correct range"); 
            tempBoardSize = scanner.nextInt(); 
        }

        System.out.println("Number of markers in a Row to Win?"); 
        this.numForWin = scanner.nextInt(); 
        while ( numForWin > tempBoardSize) {
            System.out.println("Enter in a valid size within the correct range"); 
            this.numForWin = scanner.nextInt(); 
        }

        if (this.board == null) {
            
            this.boardSize = tempBoardSize; 
            this.board = new CustomBoard(this.boardSize, this.numForWin); 

        }

        if(gameMode == 4 ){
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new HumanPlayer('O'); 
        }
        else if (gameMode == 5) {
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new ComputerPlayer(1,this.boardSize, 'O'); 
        }

    }

    @Override
    public int setGameMode() {
        
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Enter a game Mode!"); 
        
        System.out.println("Game Mode 1: Human vs Human"); 
        System.out.println("Game Mode 2: Human vs Smart Computer");
        System.out.println("Game Mode 3: Smart Computer vs Smart Computer");
        
        System.out.println("Game Mode 4: Human vs Human - Custom Board Size ");
        System.out.println("Game Mode 5: Human vs Computer - Custom Board Size"); 
        
        int tempGameMode =  scanner.nextInt(); 
        while(tempGameMode < 1 || tempGameMode > 5) {
            System.out.println("Invalid! Select a valid game mode number (1-5)"); 
            tempGameMode = scanner.nextInt(); 
        }

        return tempGameMode; 
    }

    @Override 
    public void playGame() {
        if ( getGameMode() >= 1 && getGameMode() <= 3 ) { // Huamn vs Human + HvH (custom board size)
            super.playGame();
        }
        else{
            if(getGameMode() == 4 || getGameMode() ==  5) {
                playGame(true); 
            }
        }

    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); 

        while(true){
            Game game = new CustomGame(); 
            game.playGame(); 
            System.out.println("Do you want to play again? ( yes / no)"); 
            String userReply = scanner.nextLine().trim().toLowerCase(); 
            if(!userReply.equals("yes")) {
                System.out.println("Thanks for playing, Goodbye"); 
                break; 
            }
        } 
    }


}