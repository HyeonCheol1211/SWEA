package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1220 {
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case = 1;test_case<=10;test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            StringTokenizer st;

            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                rstPlus(i, arr, N);
            }

            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }

    }


    static void rstPlus(int startI, int[][] arr, int N){
        Stack<Integer> stack = new Stack<>();
        for(int j=0;j<N;j++){
            if(arr[startI][j]==1 && stack.isEmpty()){
                stack.push(1);
            }
            if(arr[startI][j]==2 && !stack.isEmpty()){
                rst++;
                stack.clear();
            }

        }
    }
}
