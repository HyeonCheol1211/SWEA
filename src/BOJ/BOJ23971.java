package BOJ;
import java.util.*;
import java.io.*;

public class BOJ23971 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x, y;
        x = (W%(M+1) > 0) ? W/(M+1) + 1 : W/(M+1);
        y = (H%(N+1) > 0) ? H/(N+1) + 1 : H/(N+1);
        int rst = x * y;
        System.out.println(rst);
    }
}