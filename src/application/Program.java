package application;

import chess.ChessMatch;

/**
 * @author Diego Santos
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
        
        System.out.println();
        System.out.println("Tudo posso Naquele que me Fortalece!");
    }
}