package boardgame;

/**
 * @author Diego Santos
 */
public class Position {
    
    private int row;
    private int column;

    public Position(int row, int color) {
        this.row = row;
        this.column = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    public void setValues(int row, int column){
        
    }
    
    @Override
    public String toString(){
        return row + "," + column;
    }
}
