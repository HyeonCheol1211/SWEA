package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1249_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] route = new int[N][N];
            boolean[][] updated = new boolean[N][N];
            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    route[i][j] = -1;
                }
            }

            route[0][0] = map[0][0];
            route[0][1] = map[0][1];
            route[1][0] = map[1][0];

            updated[0][0] = true;

            boolean done = true;
            while(true){
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        done = done && updated[i][j];
                    }
                    if(!done){
                        break;
                    }
                }

                if(done){
                    break;
                }
                done = true;

                int[] index = getMinum(route, updated, N);
                int xIndex = index[1];
                int yIndex = index[0];
                if(yIndex-1>=0) {
                    route[yIndex - 1][xIndex] = (route[yIndex - 1][xIndex] == -1) ? route[yIndex][xIndex] + map[yIndex - 1][xIndex] : Math.min(route[yIndex][xIndex] + map[yIndex - 1][xIndex], route[yIndex - 1][xIndex]);
                }
                if(xIndex+1<=N-1) {
                    route[yIndex][xIndex + 1] = (route[yIndex][xIndex + 1] == -1) ? route[yIndex][xIndex] + map[yIndex][xIndex + 1] : Math.min(route[yIndex][xIndex] + map[yIndex][xIndex + 1], route[yIndex][xIndex + 1]);
                }
                if(yIndex+1 <= N-1) {
                    route[yIndex + 1][xIndex] = (route[yIndex + 1][xIndex] == -1) ? route[yIndex][xIndex] + map[yIndex + 1][xIndex] : Math.min(route[yIndex][xIndex] + map[yIndex + 1][xIndex], route[yIndex + 1][xIndex]);
                }
                if(xIndex-1 >= 0) {
                    route[yIndex][xIndex - 1] = (route[yIndex][xIndex - 1] == -1) ? route[yIndex][xIndex] + map[yIndex][xIndex - 1] : Math.min(route[yIndex][xIndex] + map[yIndex][xIndex - 1], route[yIndex][xIndex - 1]);
                }
            }

            System.out.printf("#%d %d\n", test_case, route[N-1][N-1]);
        }
    }

    private static int[] getMinum(int[][] route, boolean[][] updated, int N) {
        int min = Integer.MAX_VALUE;
        int[] index = new int[2];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(route[i][j] != -1 && route[i][j] <= min && !updated[i][j]){
                    min = route[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }

        updated[index[0]][index[1]] = true;
        return index;
    }
}
