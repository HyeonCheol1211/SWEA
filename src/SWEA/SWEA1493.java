package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] pXY = calXY(p);
            int[] qXY = calXY(q);
            int x = pXY[0] + qXY[0];
            int y = pXY[1] + qXY[1];
            int rst = getRst(x, y);
            System.out.printf("#%d %d\n", test_case, rst);
        }
    }

    static int[] calXY(int n){
        int[] nXY = new int[2];
        int i;
        n--;
        for(i=1;;i++){
            if(n-i <0){
                break;
            }
            n -= i;
        }
        nXY[0] = n + 1;
        nXY[1] = i - n;
        return nXY;
    }

    static int getRst(int x, int y){
        int rst=0;
        for(int i=1;i<=x+y-2;i++){
            rst+=i;
        }
        rst += x;
        return rst;
    }
}
