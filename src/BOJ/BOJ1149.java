package BOJ;
import java.util.*;
import java.io.*;

public class BOJ1149 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n+1][3];
        String s;
        for(int i=1;i<=n;i++){
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int j=0;j<3;j++){
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[1005][3];
        dp[1][0] = price[1][0];
        dp[1][1] = price[1][1];
        dp[1][2] = price[1][2];

        for(int i=2;i<=n;i++){
            dp[i][0] = Math.min(price[i][0]+dp[i-1][1], price[i][0]+dp[i-1][2]);
            dp[i][1] = Math.min(price[i][1]+dp[i-1][0], price[i][1]+dp[i-1][2]);
            dp[i][2] = Math.min(price[i][2]+dp[i-1][0], price[i][2]+dp[i-1][1]);
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]),dp[n][2]));

    }
}
