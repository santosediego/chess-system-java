package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * @author Diego Santos
 */
public abstract class ChessPiece extends Piece{
    
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public ChessPosition getChessPosotion(){
        return ChessPosition.fromPosition(position);
    }
    
    /*protected = porque eu quero que essa funão seja somente acessivel pelo o mesmo pacote e 
    as mesmas classes que são as peças*/
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
