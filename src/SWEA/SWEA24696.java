package SWEA;

import java.util.*;
import java.io.*;
public class SWEA24696 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int rst = A*B*C -1;
            if(rst%2 == 0){
                System.out.println("2");
            }else{
                System.out.println("1");
            }

        }
    }
}
