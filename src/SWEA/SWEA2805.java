package SWEA;
import java.util.*;
import java.io.*;

public class SWEA2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int rst=0;
            for(int j=0;j<N;j++){
                String s = br.readLine();
                for(int i=Math.abs(-(N/2)+j);i<N-Math.abs(-(N/2)+j);i++){
                    rst += s.charAt(i) - '0';
                }
            }
            System.out.printf("#%d %d\n", test_case, rst);
        }
    }
}
