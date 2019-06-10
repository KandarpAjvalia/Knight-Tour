public class Main {
    
    private static int[][] chessBoard = new int[8][8];
    private static int[] horizontalMoves = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] verticalMoves = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) {
        chessBoard[0][0] = 1;
        knightMove(0, 0, 2);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                String output = chessBoard[i][j] + " ";
                output = chessBoard[i][j] < 10 ? output + " " : output;
                System.out.print(output);
            }
            System.out.println();
        }
    }

    private static int knightMove(int xPosition, int yPosition, int moveNumber) {
        if(moveNumber == 65) {
            return 1;
        }
        int nextX, nextY;
        for(int i = 0; i < 8; i++) {
            nextX = xPosition + horizontalMoves[i];
            nextY = yPosition + verticalMoves[i];
            if(canMove(nextX, nextY)) {
                chessBoard[nextX][nextY] = moveNumber;
                moveNumber++;
                if(knightMove(nextX, nextY, moveNumber) == 1) {
                    return 1;
                }
                else {
                    moveNumber--;
                    chessBoard[nextX][nextY] = 0;
                }
            }
        }
        return 0;
    }

    private static boolean canMove(int x, int y) {
        return (x < 8 && y < 8 && x >= 0 && y >= 0 && chessBoard[x][y] == 0);
    }
}
