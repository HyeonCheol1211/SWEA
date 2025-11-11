package SWEA;
import java.util.*;
import java.io.*;

public class SWEA3752 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int[] score = new int[N];
            int[] dp = new int[10001];
            dp[0] = 1;
            int rst=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                score[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                for(int j=10000-score[i];j>=0;j--){
                    if(dp[j] != 0){
                        dp[j+score[i]]++;
                    }
                }
            }

            for(int i=0;i<10001;i++){
                if(dp[i] != 0){
                    rst++;
                }
            }

            System.out.printf("#%d %d\n", test_case, rst);
        }

    }
}
