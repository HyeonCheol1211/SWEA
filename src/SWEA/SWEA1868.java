package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1868 {

    static class Node implements Comparable<Node>{
        int y, x, value;
        public Node(int y, int x, int value){
            this.y = y;
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }

    static int rst = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            boolean[][] visited = new boolean[N][N];
            int[] nY = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] nX = {0, 1, 1, 1, 0, -1, -1, -1};

            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        visited[i][j] = true;
                    } else {
                        int sum = 0;
                        for (int k = 0; k < 8; k++) {
                            int nextY = i + nY[k];
                            int nextX = j + nX[k];
                            if (nextY < 0 || nextY > N - 1 || nextX < 0 || nextX > N - 1) continue;
                            if (map[nextY][nextX] == '*') sum++;
                        }
                        map[i][j] = (char) ((char) sum + '0');
                        pq.offer(new Node(i, j, sum));
                    }
                }
            }

            while(!pq.isEmpty()){
                Node n = pq.poll();
                int cy = n.y;
                int cx = n.x;
                int value = n.value;
                if(visited[cy][cx]) continue;
                if(value == 0){
                    rst++;
                    bfs(map, visited, cy, cx, N);
                }else{
                    visited[cy][cx] = true;
                    rst++;
                }
            }

            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }

    }

    static void bfs(char[][] map, boolean[][] visited, int cy, int cx, int N){
        int[] nY = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] nX = {0, 1, 1, 1, 0, -1, -1, -1};
        visited[cy][cx] = true;
        for(int i=0;i<8;i++){
            int nextY = cy + nY[i];
            int nextX = cx + nX[i];
            if(nextY<0||nextY>N-1||nextX<0||nextX>N-1) continue;
            if(map[nextY][nextX] == '0' && !visited[nextY][nextX]){
                bfs(map, visited, nextY, nextX, N);
            }else if(!visited[nextY][nextX]){
                visited[nextY][nextX] = true;
            }
        }
    }
}
