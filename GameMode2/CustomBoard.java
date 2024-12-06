

public class CustomBoard extends Board{

    private int numForWin; 

    public CustomBoard(int size, int numForWin){
        super(size); 
        this.numForWin = numForWin; 
    }

    @Override
    public boolean checkRow(char symbol) {
        for (int i = 0; i < this.size; i++) { 
            for (int j = 0; j <= this.size - this.numForWin; j++) { 
                boolean win = true;
                for (int k = 0; k < this.numForWin; k++) { 
                    if (board[i][j + k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkColumn ( char symbol) {

        for (int j  = 0; j < this.size ; j++) {
            for(int i  = 0; i <= this.size - this.numForWin; i++){ 
                boolean win = true; 
                for (int k = 0; k < this.numForWin ; k++) {
                    if (board[i + k][j] != symbol){
                        win = false; 
                        break; 
                    }
                }
                
                if(win) {
                    return true; 
                }
            }
        }
        return false; 

    } 

    @Override
    public boolean checkDiagonal1(char symbol) {
        for (int i = 0; i <= this.size - this.numForWin; i++) {
            for (int j = 0; j <= this.size - this.numForWin; j++) {
                boolean win = true;
                for (int k = 0; k < this.numForWin; k++) { 
                    if (board[i + k][j + k] != symbol) {
                        win = false; 
                        break;
                    }
                }
                if (win) {
                    return true; 
                }
            }
        }
        return false; 
    }

    @Override
    public boolean checkDiagonal2(char symbol) {

        for (int i = 0; i <= this.size - this.numForWin; i++) {
            for (int j = this.numForWin - 1; j < this.size; j++) {
                boolean win = true; 
                for (int k = 0; k < this.numForWin; k++) { 
                    if (board[i + k][j - k] != symbol) {
                        win = false; 
                        break;
                    }
                }
                if (win) {
                    return true; 
                }
            }
        }
        return false; 
    }

}