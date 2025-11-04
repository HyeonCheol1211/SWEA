package SWEA;
import java.util.*;
import java.io.*;

public class SWEA2806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int n = Integer.parseInt(br.readLine());

            int[][] rst = fill(n);

            System.out.println("#" + test_case);
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++){
                    System.out.print(rst[j][i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] fill(int n) {
        int[][] rst = new int[n][n];

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        int dir = 0;
        int startI = 0;
        int startJ = 0;
        int startNum = 1;

        while (startNum <= n * n) {

            if (startNum > n * n) break;
            rst[startI][startJ] = startNum;
            startNum++;

            int nextI = startI + di[dir];
            int nextJ = startJ + dj[dir];

            if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n || rst[nextI][nextJ] != 0) {
                dir = (dir + 1) % 4;

                startI += di[dir];
                startJ += dj[dir];
            } else {
                startI = nextI;
                startJ = nextJ;
            }
        }

        return rst;
    }
}