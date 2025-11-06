package BOJ;
import java.util.*;
import java.io.*;

public class BOJ2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;
        for(int i=0;i<=n;i++){
            if(dp[i]!=0){
                if(i+3 < n+1 ) {
                    if(dp[i+3] == 0){
                        dp[i+3] = dp[i] + 1;
                    }else{
                        dp[i+3] = Math.min(dp[i+3], dp[i] + 1);
                    }

                }
                if(i+5 < n+1) {
                    if(dp[i+5] == 0){
                        dp[i+5] = dp[i] + 1;
                    }else {
                        dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
                    }
                }
            }
        }
        if(dp[n] == 0){
            System.out.println("-1");
        }else{
        System.out.println(dp[n]);
        }
    }
}
