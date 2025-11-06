package BOJ;
import java.util.*;
import java.io.*;

public class BOJ14888 {

    static int max = -1000000001;
    static int min= 1000000001;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[2*N - 1];
        int[] oper = new int[4];
        for(int i =0;i<2*N;i+=2){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num, oper, 1, N);
        System.out.printf("%d\n%d", max, min);

    }


    static void dfs(int[] num, int[] oper, int index, int n){
        if(index == 2*n - 1){
//            for(int i=0;i<2*n-1;i++){
//                System.out.print(num[i] + " ");
//            }
//            System.out.println();
            int tem = num[0];
            for(int i=0;i<2*n-2;i+=2){
                if(num[i+1] == 0){
                    tem += num[i+2];
                }
                if(num[i+1] == 1){
                    tem -= num[i+2];
                }
                if(num[i+1] == 2){
                    tem *= num[i+2];
                }
                if(num[i+1] == 3){
                    tem /= num[i+2];
                }
            }
            max = Math.max(max, tem);
            min = Math.min(min, tem);

            return;
        }

        for(int i=0;i<4;i++){
            if(oper[i]>0){
                num[index] = i;
                oper[i]--;
                dfs(num, oper, index+2, n);
                num[index] = 0;
                oper[i]++;
            }
        }
    }
}
