

import java.util.Scanner; 


public class Game { 

    private Board board; 
    private int boardSize; 

    
    private Player player1;
    private Player player2; 

    private int gameMode; 
    boolean tryAgain = false; 

    public Game() {

        newGame(); 
        
        this.gameMode = setGameMode(); 

        if ( gameMode == 1 ) {
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new HumanPlayer('O'); 
            this.boardSize = 3; 
        }

        else if ( gameMode == 2 ){
            this.boardSize = 3; 
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new ComputerPlayer(1,3,'O');
            
        }
        else if (gameMode == 3 ) {
            Scanner scanner = new Scanner(System.in); 
            System.out.println("Create your own N*N board 3 <= N <= 20");
            this.boardSize = scanner.nextInt(); 
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new HumanPlayer('0'); 
        }
        else if (gameMode == 4) {
            Scanner scanner = new Scanner(System.in); 
            System.out.println("Create your own N*N board 3 <= N <= 20");
            this.boardSize = scanner.nextInt(); 
            this.player1 = new HumanPlayer('X'); 
            this.player2 = new ComputerPlayer(1, this.boardSize, 'O');
        }


        this.board = new Board(boardSize); 


    } 

    public void newGame(){ 
        
        System.out.println(); 
        System.out.println("This is a tic-tac-toe text based game"); 
        System.out.println("To place a marker format -> row#, col#, seperate by column \n");

    }

    public int setGameMode() {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Game Mode 1: Human vs Human"); 
        System.out.println("Game Mode 2: Human vs Computer");
        System.out.println("Game Mode 3: Human vs Human - Custom Board Size "); 
        System.out.println("Game Mode 4: Human vs Computer  - Custom Board Size"); 
        int tempGameMode =  scanner.nextInt(); 
        return tempGameMode; 

    }

    public int getTempGameMode() {return gameMode; }
    
    public void setMarker(int row, int col, char symbol) {

        char[][] currentBoard = board.getCurrentBoard(); 
        tryAgain = false; 
        if (currentBoard[row-1][col-1] != '?') {
            if(getTempGameMode() == 1 ) {
                System.out.println("Error, this spot is already filled try again"); 
            }
            tryAgain = true; 
            return; 
        }
        board.placeMarkers(row, col, symbol);  
    }
    
    
    public void playGame(boolean isMode2) {
        
        Player temp_player = player1; 
        

        Scanner scanner = new Scanner(System.in); 
   
 
        while(true) {
      
            if (tryAgain) {

                if(temp_player == player1) {
                    temp_player = player1; 
                }
                else{
                    temp_player = player2; 
                }
            }

            if (temp_player == player1 || !isMode2) { // Human player or GameMode1
                System.out.println((temp_player == player1) ? "Player 1 enter location to place markers" : "Player 2 enter location to place markers");
                String playerLocation = scanner.nextLine();
                String[] gridLocation = playerLocation.split(","); 
    
                setMarker(Integer.parseInt(gridLocation[0]), Integer.parseInt(gridLocation[1]), temp_player.getPlayerSymbol()); 

            } 
            else { // Computer move in GameMode2
                boolean validMove = false; 
                while (!validMove) {
                    int[] computerGridLocation = temp_player.getComputerMove(); 
                    setMarker(computerGridLocation[0], computerGridLocation[1], temp_player.getPlayerSymbol()); 
                    if (!tryAgain) {
                        validMove = true; 
                        System.out.println("Computer Move: " + computerGridLocation[0] + "," + computerGridLocation[1]);
                    }
                }
            }
           
        
    
            if (board.checkWin(temp_player.getPlayerSymbol())) {
                if(temp_player == player1) {
                    System.out.println("Player 1 Wins!"); 
                }
                else{
                    if(getTempGameMode() == 2 ){
                        System.out.println("Computer Wins!"); 
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

        if (getTempGameMode() == 1 ) {
            gameMode = 1; 
            playGame(false); 
        }
        else if (getTempGameMode() == 2 ) { 
            gameMode = 2; 
            playGame(true); 
        }

        else if (getTempGameMode() == 3) {
            gameMode = 3;
            playGame(false); 
        }

        else if ( getTempGameMode() == 4 ) {
            gameMode = 4;
            playGame(true); 
        }

    }

    public static void main (String[] args) {
        
        Game game = new Game();  
        game.playGame(); 

    }

}