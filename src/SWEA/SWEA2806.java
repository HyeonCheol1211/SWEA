package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2806 {

    static int count = 0;
    static int N;

    static boolean[] isRowUsed;
    static boolean[] isLeftDiagUsed;
    static boolean[] isRightDiagUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            count = 0;
            isRowUsed = new boolean[N];
            isLeftDiagUsed = new boolean[2 * N - 1];
            isRightDiagUsed = new boolean[2 * N - 1];

            placeQueen(0);

            System.out.printf("#%d %d\n", test_case, count);
        }
    }

    public static void placeQueen(int currentColumn) {
        if (currentColumn == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {

            int row = i;
            int column = currentColumn;
            int leftDiagIndex = row + column;
            int rightDiagIndex = N - 1 - row + column;

            if (!isRowUsed[row] &&
                    !isLeftDiagUsed[leftDiagIndex] &&
                    !isRightDiagUsed[rightDiagIndex]) {

                isRowUsed[row] = true;
                isLeftDiagUsed[leftDiagIndex] = true;
                isRightDiagUsed[rightDiagIndex] = true;

                placeQueen(column + 1);

                isRowUsed[row] = false;
                isLeftDiagUsed[leftDiagIndex] = false;
                isRightDiagUsed[rightDiagIndex] = false;
            }
        }
    }
}