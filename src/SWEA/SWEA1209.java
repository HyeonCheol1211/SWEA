package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1209 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case=1; test_case<=10;test_case++){
            int t = Integer.parseInt(br.readLine());
            int rst = Integer.MIN_VALUE;
            int [][] arr = new int[100][100];
            StringTokenizer st;
            for(int j=0;j<100;j++){
                st = new StringTokenizer(br.readLine());
                int tem = 0;
                for(int i=0;i<100;i++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    tem += arr[i][j];
                }
                rst = Math.max(rst, tem);
            }

            for(int i=0;i<100;i++){
                int tem = 0;
                for(int j=0;j<100;j++){
                    tem += arr[i][j];
                }
                rst = Math.max(rst, tem);
            }

            int tem1 = 0;
            int tem2 = 0;

            for(int i=0;i<100;i++){
                tem1 += arr[i][i];
                tem2 += arr[100-i-1][100-i-1];
            }
            rst = Math.max(tem1, rst);
            rst = Math.max(tem2, rst);

            System.out.printf("#%d %d\n", t, rst);

        }
    }
}
