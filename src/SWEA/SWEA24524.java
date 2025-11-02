package SWEA;
import java.util.*;
import java.io.*;

public class SWEA24524 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case=1;test_case<=T;test_case++){

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            int rst = 0;
            for(int i=0;i<n-1;i++){
                rst += Math.abs(arr[i+1] - arr[i]);
                int distance = 0;
                if(i!=0) {
                    distance = Math.abs(arr[i] - arr[i - 1]) + Math.abs(arr[i] - arr[i + 1]) - Math.abs(arr[i - 1] - arr[i + 1]);
                    max = Math.max(max, distance);
                }
            }
            rst -= max;
            System.out.println(rst);
        }
    }
}
