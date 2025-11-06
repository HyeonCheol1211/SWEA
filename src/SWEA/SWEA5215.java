package SWEA;
import java.util.*;
import java.io.*;

public class SWEA5215 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int rst;

            int[][] food = new int[2][N];
            int[] dp = new int[L+1];
            boolean[][] check = new boolean[L+1][N];
            dp[0] = 0;
            for(int i=0;i<N;i++){
                s = br.readLine();
                st = new StringTokenizer(s);
                food[0][i] = Integer.parseInt(st.nextToken());
                food[1][i] = Integer.parseInt(st.nextToken());
            }

            for(int j=0;j<L;j++){
                if(j != 0){
                    if(dp[j] <= dp[j-1]) {
                        dp[j] = dp[j - 1];
                        check[j] = check[j - 1].clone();
                    }
                }

                for(int i=0;i<N;i++) {
                    if (food[1][i] + j <= L && !check[food[1][i] + j][i]) {
                        dp[food[1][i] + j] = dp[j] + food[0][i];
                        check[food[1][i] + j] = check[j].clone();
                        check[food[1][i] + j][i] = true;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, dp[L]);

        }
    }
}
