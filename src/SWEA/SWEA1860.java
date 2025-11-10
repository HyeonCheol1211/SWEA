package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1860 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            boolean rst = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N];
            int[] bread = new int[1111200];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(time);

            for(int i=0;i<N;i++){
                if((time[i]/M)*K < i+1){
                    rst = false;
                    break;
                }
            }

            if(rst){
                System.out.println("#" + test_case + " Possible");
            }else{
                System.out.println("#" + test_case + " Impossible");
            }

        }
    }
}
