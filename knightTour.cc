#include<iostream>

using namespace std;

class knightProject {
public:
    int chessBoard[8][8] = {};
    int horizontalMoves[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
    int verticalMoves[8] = {-1, 1, -2, 2, -2, 2, -1, 1};
    bool canMove(int x, int y);
    int knightMove(int x, int y, int moveNumber);
};

bool knightProject::canMove(int x, int y) {
    return (x < 8 && y < 8 && x >= 0 && y >= 0 && chessBoard[x][y] == 0);
}

int knightProject::knightMove(int xPosition, int yPosition, int moveNumber) {
    if(moveNumber == 65) {
            return 1;
    }
    
    int nextX;  
    int nextY;    
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

int main() {
    knightProject knight;
    knight.chessBoard[0][0] = 1;
    knight.knightMove(0, 0, 2);
    for(int i = 0; i < 8; i++) {
        for(int j = 0; j < 8; j++) {
            if (knight.chessBoard[i][j] < 10) {
                cout <<knight.chessBoard[i][j] << "    ";
            } 
            else {
            	cout <<knight.chessBoard[i][j] << "   ";
            }
        }
        cout<<"\n";
    }
