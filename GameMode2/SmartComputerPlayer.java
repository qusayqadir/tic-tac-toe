import java.util.Random; 

public class SmartComputerPlayer extends ComputerPlayer{

    private Board board;

    public SmartComputerPlayer (int min, int max, char symbol, Board board) {
        super(min, max, symbol); 
        this.board = board; 
    }


    @Override
    public int[] getMove() {

        Random random = new Random(); 

        int[] moves = new int[2]; 

        char [][] currentBoard = board.getCurrentBoard();
        char mySymbol = this.getPlayerSymbol(); 
        char opponentSymbol = (this.getPlayerSymbol() == 'X') ? 'O' : 'X'; 
        int boardSize = board.getCurrentBoard().length;



        // step 1 : 
        int [] winMoves = winMove(mySymbol, currentBoard);
        if (winMoves != null) {
            return winMoves; 
        } 
        //step 2: 

        int[] blockMoves = winMove(opponentSymbol, currentBoard); 
        if (blockMoves != null ) {
            return blockMoves; 
        }


        // step 3
        int center = boardSize / 2; 
        if (currentBoard[center][center] == '?'){
            moves[0] = center + 1; 
            moves[1] = center + 1 ; 

            return moves; 

        }

        //step 4 
        int[][] corners = {{0,0},{boardSize-1, 0},{0, boardSize - 1 },{boardSize - 1, boardSize - 1 }};
        for ( int[] corner : corners ) {

            if(currentBoard[corner[0]][corner[1]] == '?') {
                moves[0] = corner[0] + 1; 
                moves[1] = corner[1] +1;
                return moves; 
            }

        }
    
        int Randrow;
        int Randcol; 

        do {
            Randrow = random.nextInt(boardSize) + 1;
            Randcol = random.nextInt(boardSize) + 1; 
            
        }while(currentBoard[Randrow-1][Randcol-1] != '?');

        moves[0] = Randrow; 
        moves[1] = Randcol; 

        return moves; 
    } 

   private int[] winMove( char symbol, char[][] board) {
        
        int boardSize = board.length;
        int[] moves = new int[2]; 


        // Check rows
        for (int i = 0; i < boardSize; i++) {

            int symbolCount = 0;
            boolean isemptyIndex = false; 
            int emptyIndex = -1; 

            for (int j = 0; j < boardSize; j++) {

                if (board[i][j] == symbol) {
                    symbolCount++;
                }

                else if (board[i][j] == '?') {
                    isemptyIndex = true; 
                    emptyIndex = j; 


                }
            }

            if (symbolCount == boardSize - 1 && isemptyIndex) {
                moves[0] = i + 1; 
                moves[1] = emptyIndex + 1 ; 
                return moves; 
            }
        }

        // Check columns

        for (int j = 0; j < boardSize; j++) {

            int symbolCount = 0;
            boolean isemptyIndex = false; 
            int emptyIndex = -1;

            for (int i = 0; i < boardSize; i++) {

                if (board[i][j] == symbol) {
                    symbolCount++;
                } 

                else if (board[i][j] == '?') {
                    isemptyIndex = true; 
                    emptyIndex = i;
                } 

            }

            if (symbolCount == boardSize - 1 && isemptyIndex) {
                moves[0] = emptyIndex + 1 ;
                moves[1] = j + 1; 
                return moves; 
   

            }
        }

        // diagonal (top-left to bottom-right)
        int symbolCount = 0;
        int emptyRow = -1;
        int emptyCol = -1;

        for (int i = 0; i < boardSize; i++) {

            if (board[i][i] == symbol){
                symbolCount++;
            } 

            else if (board[i][i] == '?') {
                emptyRow = i;
                emptyCol = i;
            }

        }
        if (symbolCount == boardSize - 1 && emptyRow != -1) {
            moves[0] = emptyRow + 1; 
            moves[1] = emptyCol + 1 ; 
            return moves; 
        }

        // diagonal (top-right to bottom-left)
        symbolCount = 0;
        emptyRow = -1;
        emptyCol = -1;

        for (int i = 0; i < boardSize; i++) {

            if (board[i][boardSize - 1 - i] == symbol){ 
                symbolCount++;
            } 

            else if (board[i][boardSize - 1 - i] == '?') {
                emptyRow = i;
                emptyCol = boardSize - 1 - i;
            }

        }

        if (symbolCount == boardSize - 1 && emptyRow != -1) {
            moves[0] = emptyRow + 1 ;
            moves[1] = emptyCol + 1 ;
            return moves; 
          
        }

        return null; 
    }

}

