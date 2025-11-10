package SWEA;
import java.util.*;
import java.io.*;

public class SWEA4615 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] board = new char[N][N];

            for(int i=0;i<2;i++){
                board[N/2-i][N/2-1+i] = 'B';
                board[N/2-1+i][N/2-1+i] = 'W';
            }

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int stoneI = Integer.parseInt(st.nextToken());
                int stoneJ = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                setStone(board, stoneJ-1, stoneI-1, color, N);
            }
            int black = cntBlack(board, N);
            System.out.printf("#%d %d %d\n", test_case, black, M + 4 -black);
        }
    }

    static void setStone(char[][] board, int stoneI, int stoneJ, int color, int N){
        char myStone = (color == 1) ? 'B' : 'W';
        char yourStone = (color == 1) ? 'W' : 'B';


        board[stoneI][stoneJ] = myStone;

        int[] indexX = {-1, 0, 1, -1, 1, -1 ,0, 1};
        int[] indexY = {1, 1, 1, 0, 0, -1, -1, -1};
        int k;
        boolean blocked = false;
        for(int i=0;i<8;i++){
            for(k=1;;k++) {
                int checkX = stoneI + indexX[i]*k;
                int checkY = stoneJ + indexY[i]*k;

                if (checkX > N - 1 || checkX < 0 || checkY > N - 1 || checkY < 0) {
                    break;
                }

                if(board[checkX][checkY] == myStone){
                    blocked = true;
                    break;
                }

                if(board[checkX][checkY] == '\u0000'){
                    break;
                }
            }
            if(blocked){
                for(int j=1;j<k;j++){
                    if(board[stoneI+indexX[i]*j][stoneJ+indexY[i]*j] == yourStone) {
                        board[stoneI + indexX[i] * j][stoneJ + indexY[i] * j] = myStone;
                    }
                }
            }
            blocked = false;
        }
    }

    static int cntBlack(char[][] board, int N){
        int rst = 0;
        for(int j=0;j<N;j++){
            for(int i=0;i<N;i++){
                if(board[i][j] == 'B'){
                    rst++;
                }
            }
        }
        return rst;
    }

}
