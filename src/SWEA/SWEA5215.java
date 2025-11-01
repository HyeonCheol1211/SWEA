package SWEA;
import java.util.*;
import java.io.*;

public class SWEA5215 {
    public static void mian(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int rst;

            int[][] food = new int[20][2];
            int[] dp = new int[L+1];
            for(int i=0;i<N;i++){
                s = br.readLine();
                st = new StringTokenizer(s);
                food[i][0] = Integer.parseInt(st.nextToken());
                food[i][1] = Integer.parseInt(st.nextToken());
            }
            


        }
    }
}
