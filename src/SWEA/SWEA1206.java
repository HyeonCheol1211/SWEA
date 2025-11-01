package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int[] apt = new int[N];
            for (int i = 0; i < N; i++) {
                apt[i] = Integer.parseInt(st.nextToken());
            }
            int rst = 0;
            for (int i = 2; i < N - 2; i++) {
                int min = 257;
                int tem;
                for (int j = -2; j < 3; j++) {
                    if (j == 0) {
                        j++;
                    }
                    tem = apt[i] - apt[i + j];
                    if (tem <= 0) {
                        min = 257;
                        break;
                    }
                    min = (tem < min) ? tem : min;
                }
                if (min != 257) {
                    rst += min;
                }
            }

            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }
    }
}
