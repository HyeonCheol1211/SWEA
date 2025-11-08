package SWEA;
import java.util.*;
import java.io.*;

public class SEWA2817 {
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] back = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(arr, back,0, K, N, 0);

            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }
    }

    static void dfs(int[] arr, int[] back, int back_index, int K, int N, int arrIndex){
        int sum=0;
        for(int i=0;i<back_index;i++){
            sum += back[i];
        }
        if(sum == K){
            rst++;
            return;
        }
        if(back_index == N){
            return;
        }
        for(int i=arrIndex;i<N;i++){
            back[back_index] = arr[i];
            dfs(arr, back, back_index+1, K, N, i+1);
            back[back_index] = 0;
        }
    }

}
