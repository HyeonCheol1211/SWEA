package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1247 {
    static int rst = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case =1; test_case<=T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[2][N+2];
            boolean[] visited = new boolean[N+2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N+2;i++){
                map[0][i] = Integer.parseInt(st.nextToken());
                map[1][i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2;i<N+2;i++) {
                dfs(map, visited, N + 2, i, map[0][0], map[1][0], 0);
            }
            System.out.printf("#%d %d\n", test_case, rst);
            rst = Integer.MAX_VALUE;



        }
    }

    static void dfs(int[][] map, boolean[] visited, int len, int start, int prevX, int prevY, int sum){
        int temSum = sum;
        visited[start] = true;
        temSum += Math.abs(map[0][start] - prevX) + Math.abs(map[1][start] - prevY);
        boolean allVisited = true;
        for(int i=2;i<len;i++){
            if(!visited[i]){
                allVisited = false;
            }
        }


        if(allVisited){
            temSum += Math.abs(map[0][1] - map[0][start]) + Math.abs(map[1][1] - map[1][start]);
            rst = Math.min(rst, temSum);
            visited[start] = false;
            return;
        }


        for(int i=2;i<len;i++){
            if(!visited[i]){
                dfs(map, visited, len, i, map[0][start], map[1][start] , temSum);
            }
        }

        visited[start] = false;



    }
}
