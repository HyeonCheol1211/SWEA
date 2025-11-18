package SWEA;
import java.util.*;
import java.io.*;
public class SWEA10965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for(int i=0;i<10000001;i++){
            arr[i] = i*i;
        }
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            for(int i=1;i<=N;i++){
                if(arr[i] < N) continue;
                if(arr[i] % N == 0){
                    System.out.printf("#%d %d\n", test_case, arr[i] / N);
                    break;
                }
            }

        }
    }
}
