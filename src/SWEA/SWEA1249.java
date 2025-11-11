package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1249 {
    static int rst=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            dfs(map, visited, 0, 0, 0, N);

            System.out.printf("#%d %d\n", test_case, rst);
            rst = Integer.MAX_VALUE;
        }
    }

    static void dfs(int[][] map, boolean[][] visited, int startI, int startJ, int total, int N){
        int sum = total + map[startI][startJ];
        if(startI == N-1 && startJ == N-1){
            rst = Math.min(rst, sum);
            return;
        }
        visited[startI][startJ] = true;
        int[] dirX = {0, 1};
        int[] dirY = {1, 0};
        for(int i=0;i<2;i++){
            int nextX = startJ + dirX[i];
            int nextY = startI + dirY[i];
            if(nextX<N && nextY<N && !visited[nextY][nextX]){
                dfs(map, visited, nextY, nextX, sum, N);
            }
        }
        visited[startI][startJ] = false;
    }
}
