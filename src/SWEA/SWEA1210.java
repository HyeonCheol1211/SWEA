package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1210 {
    static int rst=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case = 1;test_case<=T;test_case++){
            int t = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for(int i=0;i<100;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cx =0;
            for(int j=0;j<100;j++){
                if(map[99][j] == 2){
                    cx = j;
                }
            }

            search(map, 99, cx, 'U');

            System.out.printf("#%d %d\n", t, rst);
        }
    }

    static void search(int[][] map, int cy, int cx, char dir){
        int y = cy;
        int x = cx;
        if(dir == 'U'){
            while(true) {
                y--;
                if(y < 0 ){
                    rst = x;
                    return;
                }
                if(x == 99){
                    if(map[y][x-1] == 1){
                        search(map, y, x, 'L');
                        return;
                    }
                }else if(x == 0){
                    if(map[y][x+1] == 1){
                        search(map, y, x, 'R');
                        return;
                    }
                }else{
                    if(map[y][x+1] == 1){
                        search(map, y, x, 'R');
                        return;
                    }
                    if(map[y][x-1] == 1){
                        search(map, y, x, 'L');
                        return;
                    }
                }
            }
        }else if(dir == 'R'){
            while(true){
                if(x == 99){
                    search(map, y, x, 'U');
                    return;
                }
                if(map[y-1][x]==1 && map[y][x+1] == 0){
                    search(map, y, x, 'U');
                    return;
                }
                x++;
            }
        }else if(dir =='L'){

            while(true){
                if(x == 0){
                    search(map, y, x, 'U');
                    return;
                }
                if(map[y-1][x]==1 && map[y][x-1] == 0){
                    search(map, y, x, 'U');
                    return;
                }
                x--;
            }
        }
    }
}
