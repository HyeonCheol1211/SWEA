package BOJ;
import java.util.*;
import java.io.*;
public class BOJ1260 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, V;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int[][] edges = new int[N][N];
        boolean[] visited1 = new boolean[N];
        boolean[] visited2 = new boolean[N];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[v1-1][v2-1] = 1;
            edges[v2-1][v1-1] = 1;
        }
        dfs(edges, visited1, V, N);
        System.out.println();
        bfs(edges, visited2, V, N, deque);



    }

    static void dfs(int[][] edges, boolean[] visited, int V, int N){
        visited[V-1] = true;
        System.out.print(V + " ");
        for(int i=0;i<N;i++){
            if(edges[V-1][i]==1 && !visited[i]){
                dfs(edges, visited, i+1, N);
            }
        }
    }

    static void bfs(int[][] edges, boolean[] visited, int V, int N, Deque<Integer> deque){
        deque.offerLast(V);
        visited[V-1] = true;
        while(!deque.isEmpty()) {
            int c = deque.pollFirst();
            System.out.print(c + " ");
            for (int i = 0; i < N; i++) {
                if (edges[c-1][i] == 1 && !visited[i]) {
                    deque.offerLast(i + 1);
                    visited[i] = true;
                }
            }
        }

    }
}
