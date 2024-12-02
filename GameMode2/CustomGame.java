import java.util.Scanner; 

public class CustomGame extends Game{


    public CustomGame() {
        super();
        customGameSetup();     
    }

    public void customGameSetup(){
        int gameMode = getGameMode(); 
        int tempBoardSize = 3; 

        if (gameMode == 4 || gameMode == 5) {
            Scanner scanner = new Scanner(System.in); 

            System.out.println("Create your own N*N board 3 <= N <= 20"); 
            tempBoardSize = scanner.nextInt(); 
            while(tempBoardSize > 20 || tempBoardSize < 3 ) {
                System.out.println("Enter in a size in the correc range"); 
                tempBoardSize = scanner.nextInt(); 
            }
        }
        this.boardSize = tempBoardSize; 
        this.board = new Board(this.boardSize); 

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
        return tempGameMode; 
    }

    @Override 
    public void playGame() {
        if ( getGameMode() == 1 || getGameMode() == 4 ) { // Huamn vs Human + HvH (custom board size)
            playGame(false); 
        }
        else if ( getGameMode() == 2 || getGameMode() == 3 || getGameMode() == 5 ) {
            playGame(true); 
        }

    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); 
        while(true){
            Game game = new CustomGame(); 
            game.playGame(); 
            System.out.println("Do you want to play again?"); 
            String userReply = scanner.nextLine().trim().toLowerCase(); 

            if(!userReply.equals("yes")) {
                System.out.println("Thanks for playing, Goodbye"); 
                break; 
            }
        } 
    }


}