package BOJ;
import java.util.*;
import java.io.*;

public class BOJ15649 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        dfs(N, M, arr, 0);
    }

    static void dfs(int N, int M, int[] arr, int index){
        if(index == M){
            for(int i=0;i<M;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=N;i++){
            boolean check = true;
            if(index==0) {
                arr[index] = i;
            }else{
                for(int j=0;j<index;j++){
                    if(arr[j] == i){
                        check = false;
                    }
                }
                if(check){
                    arr[index] = i;
                }else{
                    continue;
                }
            }
            dfs(N, M, arr, index+1);
            arr[index] = 0;
        }
    }
}
