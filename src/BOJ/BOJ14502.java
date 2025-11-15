package BOJ;
import java.util.*;
import java.io.*;


public class BOJ14502 {
    static int rst = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<=N*M-3;i++){
            int iy = i/M;
            int ix = i%M;
            if(map[iy][ix] != 0){
                continue;
            }
            for(int j=i+1;j<=N*M-2;j++){
                int jy = j/M;
                int jx = j%M;
                if(map[jy][jx] != 0){
                    continue;
                }
                for(int l=j+1;l<=N*M-1;l++){
                    int ly = l/M;
                    int lx = l%M;
                    if(map[ly][lx] != 0){
                        continue;
                    }
                    int[][] temMap = new int[N][M];
                    for(int k=0;k<N;k++) {
                        temMap[k] = map[k].clone();
                    }
                    temMap[iy][ix] = 1;
                    temMap[jy][jx] = 1;
                    temMap[ly][lx] = 1;
                    bfs(temMap, N, M);
                }
            }
        }

        System.out.println(rst);

    }

    static void bfs(int[][] temMap, int N, int M){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<N*M;i++){
            int iy = i/M;
            int ix = i%M;
            if(temMap[iy][ix] == 2){
                deque.offerLast(i);
            }
        }
        int[] my = {-1, 0, 1, 0};
        int[] mx = {0, 1, 0, -1};

        while(!deque.isEmpty()){
            int tem = deque.pollFirst();
            int y = tem / M;
            int x = tem % M;
            for(int i=0;i<4;i++){
                int nextY = y + my[i];
                int nextX = x + mx[i];
                if(nextY>N-1 || nextY<0||nextX>M-1||nextX<0) continue;
                if(temMap[nextY][nextX]==0){
                    temMap[nextY][nextX] = 2;
                    deque.offerLast(nextY*M + nextX);
                }
            }
        }
        int total = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temMap[i][j] == 0){
                    total++;
                }
            }
        }
        rst = Math.max(total, rst);
    }
}
