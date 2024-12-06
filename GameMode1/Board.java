public class Board{

    private int size;  
    private char[][] board; 
    
    public Board(int size) { 
        this.size = size; 
        this.board = new char[this.size][this.size]; 
        initialize();
        printBoard(); 
    }


    public void initialize(){

        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++) {
                board[i][j] = '?'; 
            }
        }
    }

    public void printBoard(){
        System.out.println(); 
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(" " + board[i][j] + " "); 
                if ( j < size - 1 ) {
                    System.out.print("|"); 
                }
            }
            System.out.println(); 
            if ( i < size - 1 ) { 
                String dash = "-"; 
                String printDash = dash.repeat(this.size * 4); 
                System.out.println(printDash);
            } 
        }
        System.out.println(); 
    }

    public char[][] getCurrentBoard() {
        return board; 
    }

    public void placeMarkers(int row, int col, char symbol){
        if ( row <= this.size && row >= 0 && col <= this.size  && col >= 0 && board[row-1][col-1] == '?' ) {
            board[row-1][col-1] = symbol; 
            printBoard();
        }

    }

    public boolean checkWin(char symbol){

        if ( checkRow(symbol) || checkColumn(symbol) || checkDiagonal1 (symbol) || checkDiagonal2(symbol)) {
            return true; 
        }
        return false; 
    }

    // the follow method 
    public boolean checkRow( char symbol) {

       
        for (int i = 0; i < this.size ; i++){
            boolean win = true; 
            for (int j=0; j < this.size ; j++) {
                if (board[i][j] != symbol ){
                    win = false; 
                    break;
                }
            }
            if (win) {
                return true; 
            }
        }

        return false; 

 
    }

    public boolean checkColumn ( char symbol) {

        for (int j  = 0; j < this.size ; j++) {
            boolean win = true; 
            for (int i = 0; i < this.size ; i++) {
                if (board[i][j] != symbol){
                    win = false; 
                    break; 
                }
            }
            if(win) {
                return true; 
            }
        }
        return false; 

    } 

    public boolean checkDiagonal1(char symbol) {
      
        boolean win = true; 
        for (int i =0; i < this.size; i++) {
            if (board[i][i] != symbol){
                win = false; 
                break; 
            }

        }

        if (win) { 
            return true; 
        }
        else{
            return false; 
        }

    }
 
    public boolean checkDiagonal2(char symbol ) {

        boolean win = true; 
        for (int i = 0; i < this.size; i++) {
            if (board[i][this.size - i - 1] != symbol) {
                return false; 
            }
        }

        return true; 

    }


    public boolean checkBoardFull() {


       
        int unfilledSpace = 0; 
        for(int i  = 0; i < this.size ; i++){
            for(int j =0; j < this.size ; j++) {
                if (board[i][j] == '?') {
                    unfilledSpace++; 
                }
            }
        }
        if (unfilledSpace == 0 ){ 
            return true; 
        }

        return false; 
    }
    


}