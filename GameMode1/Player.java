package Assignment06; 



public abstract class Player { 

    protected char symbol = ' '; 


    public Player (char symbol) { 

        this.symbol = symbol; 
    }

    public char getPlayerSymbol() {
        return this.symbol;
    }

    public abstract int[] getMove();




}