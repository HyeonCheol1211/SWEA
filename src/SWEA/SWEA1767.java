package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1767 {
    static int cnt=0;
    static int rst=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] core = new int[2][12];
        for(int test_case=1;test_case<=T;test_case++){
            int len=0;
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j]==1){
                        if(i==0 || j==0 || i==N-1||j==N-1){
                            cnt++;
                            continue;
                        }
                        core[0][len] = i;
                        core[1][len] = j;
                        len++;
                    }
                }
            }

            dfs(board, core, 0, len, 0, cnt, N);

            System.out.printf("#%d %d\n", test_case, rst);
            cnt = 0;
            rst=Integer.MAX_VALUE;

        }

    }

    static void dfs(int[][] board, int[][] core, int start, int len, int sum, int conCore, int N){
        if(len<=start){
            if(cnt<conCore){
                cnt = conCore;
                rst = sum;
            }else if(cnt == conCore) {
                rst = Math.min(sum, rst);
            }
            return;
        }
        int totalSum = sum;
        int connect = conCore;
        int cy = core[0][start];
        int cx = core[1][start];
        for(int i=0;i<4;i++){
            boolean conSuc=true;
            if(i==0){
                int j;
                for(j=cy-1;j>=0;j--){
                    if(board[j][cx] != 0){
                        conSuc = false;
                        break;
                    }
                    board[j][cx] = 2;
                    totalSum++;
                }
                if(conSuc) {
                    dfs(board, core, start + 1, len, totalSum, connect+1, N);
                    for(int k=j+1;k<cy;k++){
                        board[k][cx] = 0;
                        totalSum--;
                    }
                }else{
                    for(int k=j+1;k<cy;k++){
                        board[k][cx] = 0;
                        totalSum--;
                    }
                    dfs(board, core, start+1, len, totalSum, connect, N);
                }
            }else if(i==1){
                int j;
                for(j=cx+1;j<N;j++){
                    if(board[cy][j] != 0){
                        conSuc = false;
                        break;
                    }
                    board[cy][j] = 2;
                    totalSum++;
                }
                if(conSuc) {
                    dfs(board, core, start + 1, len, totalSum, connect+1, N);
                    for(int k=j-1;k>cx;k--){
                        board[cy][k] = 0;
                        totalSum--;
                    }
                }else{
                    for(int k=j-1;k>cx;k--){
                        board[cy][k] = 0;
                        totalSum--;
                    }
                    dfs(board, core, start+1, len, totalSum, connect, N);
                }
            }else if(i==2){
                int j;
                for(j=cy+1;j<N;j++){
                    if(board[j][cx] != 0){
                        conSuc = false;
                        break;
                    }
                    board[j][cx] = 2;
                    totalSum++;
                }
                if(conSuc) {
                    dfs(board, core, start + 1, len, totalSum, connect+1, N);
                    for(int k=j-1;k>cy;k--){
                        board[k][cx] = 0;
                        totalSum--;
                    }
                }else{
                    for(int k=j-1;k>cy;k--){
                        board[k][cx] = 0;
                        totalSum--;
                    }
                    dfs(board, core, start+1, len, totalSum, connect, N);
                }
            }else {
                int j;
                for(j=cx-1;j>=0;j--){
                    if(board[cy][j] != 0){
                        conSuc = false;
                        break;
                    }
                    board[cy][j] = 2;
                    totalSum++;
                }
                if(conSuc) {
                    dfs(board, core, start + 1, len, totalSum, connect+1, N);
                    for(int k=j+1;k<cx;k++){
                        board[cy][k] = 0;
                        totalSum--;
                    }
                }else{
                    for(int k=j+1;k<cx;k++){
                        board[cy][k] = 0;
                        totalSum--;
                    }
                    dfs(board, core, start+1, len, totalSum, connect, N);
                }

            }
        }
    }
}
