public class KnightTour {
    private static int[][] chessBoard = new int[8][8];
    public static void main(String[] args) {
        //pair of moves of knight, same index in horizontalMoves and verticalMoves corresponds to x and y coordinate move
        int[] horizontalMoves = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] verticalMoves = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
        chessBoard[0][0] = 1;
        knightMove(0,0, horizontalMoves, verticalMoves, 2);
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(chessBoard[i][j] < 10) {
                    System.out.print(chessBoard[i][j] + "  ");
                }
                else {
                    System.out.print(chessBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int knightMove(int xPosition, int yPosition, int[] horizontalMove, int[] verticalMove, int currentMove) {
        if(currentMove == 65) {
            return 1;
        }
        int nextX;
        int nextY;
        for(int i = 0;i < 8; i++) {
            nextX = xPosition + horizontalMove[i];
            nextY = yPosition + verticalMove[i];
            if(canMove(nextX, nextY)) {
                chessBoard[nextX][nextY] = currentMove;
                currentMove++;
                if(knightMove(nextX, nextY, horizontalMove, verticalMove, currentMove) == 1) {
                    return 1;
                }
                else {
                    currentMove--;
                    chessBoard[nextX][nextY] = 0;
                }
            }
        }
        return 0;
    }

    private static boolean canMove(int x, int y) {
        return (x < 8 && y < 8 && x >= 0 && y>= 0 && chessBoard[x][y] == 0);
    }

}
