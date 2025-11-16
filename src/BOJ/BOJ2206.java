package BOJ;
import java.io.*;
import java.util.*;

public class BOJ2206 {

    static class Node {
        int y, x, broken;
        Node(int y, int x, int broken) {
            this.y = y;
            this.x = x;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // visited[y][x][0] = 벽 안 부숨
        // visited[y][x][1] = 벽 부숨
        boolean[][][] visited = new boolean[N][M][2];
        int[][][] dist = new int[N][M][2];

        Queue<Node> q = new LinkedList<>();

        // 시작점
        visited[0][0][0] = true;
        dist[0][0][0] = 1;
        q.offer(new Node(0, 0, 0));

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int broken = cur.broken;

            // 도착지 도달
            if (y == N-1 && x == M-1) {
                System.out.println(dist[y][x][broken]);
                return;
            }

            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny<0 || ny>=N || nx<0 || nx>=M) continue;

                // 빈 칸
                if (map[ny][nx] == 0) {
                    if (!visited[ny][nx][broken]) {
                        visited[ny][nx][broken] = true;
                        dist[ny][nx][broken] = dist[y][x][broken] + 1;
                        q.offer(new Node(ny, nx, broken));
                    }
                }

                // 벽
                else {
                    if (broken == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        dist[ny][nx][1] = dist[y][x][0] + 1;
                        q.offer(new Node(ny, nx, 1));
                    }
                }
            }
        }

        // 도달 불가
        System.out.println(-1);
    }
}
