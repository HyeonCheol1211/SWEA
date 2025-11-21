package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1824 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            char[][] map = new char[R][C];
            for(int i=0;i<R;i++){
                String s = br.readLine();
                for(int j=0;j<C;j++){
                    map[i][j] = s.charAt(j);
                }
            }

            List<List<HashSet<Node>>> visited = new ArrayList<>();
            for(int i=0;i<R;i++){
                List<HashSet<Node>> row = new ArrayList<>();
                for(int j=0;j<C;j++){
                    row.add(new HashSet<Node>());
                }
                visited.add(row);
            }

            Deque<Node> dq = new ArrayDeque<>();
            dq.offerLast(new Node(0, 0, 1, 0));

            boolean possible = bfs(map, visited, R, C, dq);

            if(possible){
                System.out.printf("#%d YES\n", test_case);
            }else{
                System.out.printf("#%d NO\n", test_case);
            }
        }
    }

    static boolean bfs(char[][] map, List<List<HashSet<Node>>> visited, int R, int C, Deque<Node> dq){
        int[] nY = {-1, 0, 1, 0};
        int[] nX = {0, 1, 0, -1};

        while(!dq.isEmpty()){
            Node cur = dq.pollFirst();
            int y = cur.y;
            int x = cur.x;
            int dir = cur.dir;
            int mem = cur.mem;

            Node state = new Node(y, x, dir, mem);
            if(visited.get(y).get(x).contains(state)) continue;
            visited.get(y).get(x).add(state);

            char cmd = map[y][x];

            if(cmd >= '0' && cmd <= '9'){
                mem = cmd - '0';
            }else if(cmd == '^'){
                dir = 0;
            }else if(cmd == '>'){
                dir = 1;
            }else if(cmd == 'v'){
                dir = 2;
            }else if(cmd == '<'){
                dir = 3;
            }else if(cmd == '+'){
                mem = (mem == 15) ? 0 : mem + 1;
            }else if(cmd == '-'){
                mem = (mem == 0) ? 15 : mem - 1;
            }else if(cmd == '_'){
                dir = (mem == 0) ? 1 : 3;
            }else if(cmd == '|'){
                dir = (mem == 0) ? 2 : 0;
            }else if(cmd == '@'){
                return true;
            }

            if(cmd == '?'){
                for(int ndir=0; ndir<4; ndir++){
                    int ny = (y + nY[ndir] + R) % R;
                    int nx = (x + nX[ndir] + C) % C;
                    dq.offerLast(new Node(ny, nx, ndir, mem));
                }
            }else{
                int ny = (y + nY[dir] + R) % R;
                int nx = (x + nX[dir] + C) % C;
                dq.offerLast(new Node(ny, nx, dir, mem));
            }
        }
        return false;
    }

    static class Node{
        int y, x, dir, mem;
        public Node(int y, int x, int dir, int mem){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.mem = mem;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof Node)) return false;
            Node n = (Node) o;
            return this.y == n.y && this.x == n.x && this.dir == n.dir && this.mem == n.mem;
        }
        @Override
        public int hashCode(){
            return Objects.hash(y, x, dir, mem);
        }
    }
}
