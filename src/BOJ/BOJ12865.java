package BOJ;
import java.util.*;
import java.io.*;

public class BOJ12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] goods = new int[n][2];
        int[] dp = new int[k+1];
        for(int i=0;i<n;i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            goods[i][0] = Integer.parseInt(st.nextToken());
            goods[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=k;j>=0;j--){
                if(j-goods[i][0]>=0){
                    dp[j] = Math.max(dp[j], dp[j-goods[i][0]] + goods[i][1]);
                }else{
                    break;
                }
            }
        }

        System.out.println(dp[k]);

    }
}
