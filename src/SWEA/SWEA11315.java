package SWEA;
import java.util.*;
import java.io.*;

public class SWEA11315 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            char[][] board = new char[N][N];
            String s;
            for(int i=0;i<N;i++){
                s = br.readLine();
                for(int j=0;j<N;j++){
                    board[i][j] = s.charAt(j);
                }
            }
            boolean allBreak = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    boolean rstRight;
                    boolean rstDown;
                    boolean rstRightDown;
                    boolean rstLeftDown;

                    rstRight = checkRight(board, i, j, N);
                    rstDown = checkDown(board, i, j, N);
                    rstRightDown = checkRightDown(board, i, j, N);
                    rstLeftDown = checkLeftDown(board, i, j, N);

                    if(rstRight || rstDown || rstRightDown || rstLeftDown){
                        System.out.printf("#%d YES\n", test_case);
                        allBreak = true;
                        break;
                    }

                }

                if(allBreak){
                    break;
                }
            }

            if(!allBreak){
                System.out.printf("#%d NO\n", test_case);
            }
        }
    }

    static boolean checkRight(char[][] board, int i, int j, int N){
        boolean five = true;
        if(j+4 >= N){
            return false;
        }
        for(int k=0;k<5;k++){
            if(board[i][j+k] == '.'){
                five = false;
                break;
            }
        }
        return five;
    }

    static boolean checkDown(char[][] board, int i, int j, int N){
        boolean five = true;
        if(i+4 >= N){
            return false;
        }
        for(int k=0;k<5;k++){
            if(board[i+k][j] == '.'){
                five = false;
                break;
            }
        }
        return five;
    }
    static boolean checkRightDown(char[][] board, int i, int j, int N){
        boolean five = true;
        if(i+4 >= N || j+4>=N){
            return false;
        }
        for(int k=0;k<5;k++){
            if(board[i+k][j+k] == '.'){
                five = false;
                break;
            }
        }
        return five;
    }
    static boolean checkLeftDown(char[][] board, int i, int j, int N){
        boolean five = true;
        if(i+4 >= N || j-4<0){
            return false;
        }
        for(int k=0;k<5;k++){
            if(board[i+k][j-k] == '.'){
                five = false;
                break;
            }
        }
        return five;
    }


}
