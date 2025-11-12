package SWEA;
import java.util.*;
import java.io.*;

public class SWEA2819 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int test_case=1;test_case<=T;test_case++){
            int[][] board = new int[4][4];
            for(int i=0;i<4;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<4;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    dfs(board, i, j, 0, set, 0);
                }
            }
            System.out.printf("#%d %d\n", test_case, set.size());
            set.clear();
        }
    }

    static void dfs(int[][] board, int cy, int cx, int num, HashSet<Integer> set, int cnt){
        num *= 10;
        num += board[cy][cx];
        cnt++;
        if(cnt==7){
            set.add(num);
            return;
        }
        int[] ny = {-1, 0, 1, 0};
        int[] nx = {0, 1, 0, -1};

        for(int i=0;i<4;i++){
            int nextY = cy + ny[i];
            int nextX = cx + nx[i];
            if(nextX<0||nextY<0||nextX>3||nextY>3) continue;
            dfs(board, nextY, nextX, num, set, cnt);
        }

    }

}
