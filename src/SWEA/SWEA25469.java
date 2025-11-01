package SWEA;
import java.util.*;
import java.io.*;

public class SWEA25469 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W= Integer.parseInt(st.nextToken());
            int cnt=0;

            char[][] board = new char[H][W];
            String s;
            for(int i=0;i<H;i++){
                s = br.readLine();
                board[i] = s.toCharArray();
            }
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(board[i][j] == '.'){
                        break;
                    }
                    if(j==W-1){
                        cnt++;
                    }
                }
            }

            for(int j=0;j<W;j++){

                for(int i=0;i<H;i++){
                    if(board[i][j] == '.'){
                        break;
                    }
                    if(i==H-1){
                        cnt++;
                    }
                }
            }

            if(cnt == (H+W)){
                cnt = (H < W) ? H : W;
            }
            System.out.println(cnt);

        }
    }
}
