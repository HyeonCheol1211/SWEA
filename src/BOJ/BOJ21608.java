package BOJ;
import java.util.*;
import java.io.*;

public class BOJ21608 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] seat = new int[N][N];
        int [][] student = new int[N*N][5];
        int totalLove=0;
        int totalEmp = 0;
        int x=0;
        int y=0;
        int rst=0;
        for(int i=0;i<N*N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] searchY = {-1, 0, 1, 0};
        int[] searchX = {0, 1, 0, -1};

        for(int s=0;s<N*N;s++) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if(s!=0 && seat[i][j] != 0){
                        continue;
                    }
                    int love = 0;
                    int emp = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + searchY[k];
                        int nextX = j + searchX[k];
                        if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;
                        if (seat[nextY][nextX] == 0) {
                            emp++;
                            continue;
                        }
                        for (int l = 1; l < 5; l++) {
                            if (student[s][l] == seat[nextY][nextX]) {
                                love++;
                            }
                        }

                    }
                    if (love > totalLove) {
                        totalLove = love;
                        totalEmp = emp;
                        x = j;
                        y = i;
                    } else if (love == totalLove) {
                        if (emp >= totalEmp) {
                            totalLove = love;
                            totalEmp = emp;
                            x = j;
                            y = i;
                        }
                    }
                }
            }
            seat[y][x] = student[s][0];
            totalLove=0;
            totalEmp=0;
        }

        for(int s=0;s<N*N;s++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(seat[i][j]==student[s][0]){
                        int tem = 0;
                        for(int k=0;k<4;k++) {
                            int nextY = i + searchY[k];
                            int nextX = j + searchX[k];
                            if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;
                            for(int l=1;l<5;l++){
                                if(seat[nextY][nextX] == student[s][l]){
                                    tem++;
                                }
                            }
                        }
                        if(tem==1){
                            rst++;
                        }else if(tem==2){
                            rst += 10;
                        }else if(tem==3){
                            rst += 100;
                        }else if(tem==4){
                            rst += 1000;
                        }
                    }
                }
            }
        }

        System.out.println(rst);




    }
}
