package SWEA;
import java.util.*;
import java.io.*;

public class SWEA22684 {
    static int rst = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int startY = 0, startX = 0;

            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == 'X') {
                        startY = i;
                        startX = j;
                    }
                }
            }

            boolean[][] visited = new boolean[N][N];
            rst = Integer.MAX_VALUE;
            dfs(map, visited, startY, startX, 0, N, K, 0, 0);

            if (rst == Integer.MAX_VALUE)
                System.out.printf("#%d -1\n", test_case);
            else
                System.out.printf("#%d %d\n", test_case, rst);
        }
    }

    static void dfs(char[][] map, boolean[][] visited, int y, int x, int cnt, int N, int k, int dir, int depth) {
        if (cnt >= rst) return;
        if (map[y][x] == 'Y') {
            rst = Math.min(rst, cnt);
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (visited[ny][nx]) continue;

            int newCnt = cnt;
            int newK = k;

            if (dir != i) {
                if (Math.abs(dir - i) == 2) newCnt += 2;
                else newCnt += 1;
            }

            newCnt += 1;

            char c = map[ny][nx];

            if (c == 'T') {
                if (newK > 0) {
                    newK--;
                    dfs(map, visited, ny, nx, newCnt, N, newK, i, depth + 1);
                }
            } else {
                dfs(map, visited, ny, nx, newCnt, N, newK, i, depth + 1);
            }
        }

        visited[y][x] = false;
    }
}
