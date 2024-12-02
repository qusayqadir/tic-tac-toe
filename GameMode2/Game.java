import java.util.Scanner; 

public class Game { 

    protected Board board; 
    protected int boardSize; 
    
    protected Player player1;
    protected Player player2; 

    private int gameMode; 
    boolean tryAgain = false; 

    public Game() {

        newGame(); 
        
        this.gameMode = setGameMode(); 

        if (this.gameMode == 1 || this.gameMode == 2 || this.gameMode == 3) {
            this.boardSize = 3; 
            this.board = new Board(this.boardSize);
           
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



    } 

    
    public void newGame(){ 
        
        System.out.println(); 
        System.out.println("This is a tic-tac-toe text based game"); 
        System.out.println("To place a marker format -> row#, col#, seperate by column \n");
        System.out.println("To choose a row count from 1 from the top and add one as you go down");
        System.out.println("To choose a column count from 1 from the furthest left and add one as you go right\n"); 

    }

    public int setGameMode() {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Enter a game Mode!"); 
        System.out.println("Game Mode 1: Human vs Human"); 
        System.out.println("Game Mode 2: Human vs Smart Computer");
        System.out.println("Game Mode 3: Smart Computer vs Smart Computer");

        int tempGameMode =  scanner.nextInt(); 
        return tempGameMode; 

    }

    public int getGameMode() {

        return gameMode; 
    }

    public void setMarker(int row, int col, char symbol) {

        char[][] currentBoard = board.getCurrentBoard(); 
        tryAgain = false; 
        if (currentBoard[row-1][col-1] != '?') {
            if(getGameMode() == 1 ) {
                System.out.println("Error, this spot is already filled try again"); 
            }
            tryAgain = true; 
            return; 
        }
        board.placeMarkers(row, col, symbol);  
    }
    
    public void playGame(boolean isMode2) {
        
        Player temp_player = player1; 
        
 
        while(true) {
      
            if (tryAgain) {

                if(temp_player == player1) {
                    temp_player = player1; 
                }
                else{
                    temp_player = player2; 
                }
            }

            if (temp_player instanceof HumanPlayer || !isMode2) { 
                
                System.out.println((temp_player == player1 && temp_player instanceof HumanPlayer) ? "Payer 1 enter location to place markers" : "Player 2 enter location to place markers");
                
                int[] humanMoves = temp_player.getMove(); 
                int row = humanMoves[0];
                int col = humanMoves[1]; 
                
                if ( row > this.boardSize || row < 0 && col > this.boardSize || col < 0) {
                    System.out.println("Enter in a valid Row and Col"); 
                    tryAgain = true; 
                }
                else{
                    setMarker(row, col , temp_player.getPlayerSymbol()); 
                }
            

            } 
            if (temp_player instanceof SmartComputerPlayer || temp_player instanceof ComputerPlayer) { 

                boolean validMove = false; 

                while (!validMove) {

                    int[] computerGridLocation = temp_player.getMove(); 
                    setMarker(computerGridLocation[0], computerGridLocation[1], temp_player.getPlayerSymbol()); 

                    if (!tryAgain) {
                        validMove = true; 
                        System.out.println("Computer Move: " + computerGridLocation[0] + "," + computerGridLocation[1]);
                    }
                }
            }
    
            if (board.checkWin(temp_player.getPlayerSymbol())) {

                if(temp_player == player1 && temp_player instanceof HumanPlayer) {
                    System.out.println("Player 1 Wins!"); 
                }

                else{

                    if(temp_player == player1 && ( temp_player instanceof SmartComputerPlayer || temp_player instanceof ComputerPlayer )){
                        System.out.println("Computer 1 Wins!"); 
                    }

                    else if (temp_player == player2 && (temp_player instanceof SmartComputerPlayer || temp_player instanceof ComputerPlayer)) {
                        System.out.println("Computer 2 Wins!"); 
                    }

                    else{
                        System.out.println("Player 2 Wins!"); 
                    }
                }
                break; 
            }

            if (board.checkBoardFull()){
                System.out.println("Its a tie, no winners"); 
                break; 
            }

            if(!tryAgain) {
                if(temp_player == player1) {
                    temp_player = player2; 
                }
                else{
                    temp_player = player1; 
                }
            }
            
        }

    }

  
    public void playGame() {

        if (getGameMode() == 1 ) { // Human vs Human 
            playGame(false); 
        }
        else if (getGameMode() == 2 ) { // Human vs SmarComp 
            playGame(true); 
        }
        else if ( getGameMode() == 3 ) { // Comp vs SmartComp 

            playGame(true); 
        }


    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); 
        while(true) {
            Game game = new Game();  
            game.playGame(); 
            System.out.println("Do you want to play again?"); 
            String response = scanner.nextLine().toLowerCase(); 
            if(!response.equals("yes")){
                System.out.println("Thanks for playing, Goodbye!");
                break; 
            }

        }

    }

}

