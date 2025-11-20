package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1861 {
    static int rstLen = 0;
    static int rstX = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case =1; test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    search(map, i, j, 1, N);
                }
            }

            System.out.printf("#%d %d %d\n", test_case, rstX, rstLen);
            rstLen = 0;
            rstX = 0;
        }
    }

    static void search(int[][] map, int cy, int cx, int sumLen, int N){
        int len = sumLen;
        int[] nY = {-1, 0, 1, 0};
        int[] nX = {0, 1, 0, -1};
        boolean last = true;
        for(int i=0;i<4;i++){
            int nextY = cy + nY[i];
            int nextX = cx + nX[i];
            if(nextY>N-1||nextY<0||nextX>N-1||nextX<0) continue;
            if(map[cy][cx] -1 == map[nextY][nextX]){
                last = false;
                search(map, nextY, nextX, len+1, N);
            }

        }
        if(last){
            if(rstLen<len){
                rstLen = len;
                rstX = map[cy][cx];
            }else if(rstLen == len){
                rstX = Math.min(map[cy][cx], rstX);
            }
        }


    }



}
