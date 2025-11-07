package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1215 {
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case = 1;test_case<=T;test_case++){
            int len = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];
            for(int j=0;j<8;j++){
                String s = br.readLine();
                for(int i=0;i<8;i++) {
                    arr[i][j] = s.charAt(i);
                }
            }

            for(int j=0;j<8;j++){
                for(int i=0;i<8;i++) {
                    if(i+len <= 8){
                        rstPlus(i, j, len, arr, 'i');
                    }
                    if(j+len <= 8){
                        rstPlus(i, j, len, arr, 'j');
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }
    }

    static void rstPlus(int startI, int startJ, int len, char[][] arr, char dir){
        Stack<Character> stack = new Stack<>();
        if(dir == 'i'){
            for(int i=startI;i<startI + len;i++){
                if(i < startI+(len/2)){
                    stack.push(arr[i][startJ]);
                }
                if(i == startI + len/2){
                    if(len%2 == 1){
                        i ++;
                    }
                }
                if(i>=startI+(len/2)){
                    if(stack.peek() == arr[i][startJ]){
                        stack.pop();
                    }
                }
            }
        }else{
            for(int j=startJ;j<startJ + len;j++){
                if(j < startJ+(len/2)){
                    stack.push(arr[startI][j]);
                }
                if(j == startJ + len/2){
                    if(len%2 == 1){
                        j ++;
                    }
                }
                if(j>=startJ+(len/2)){
                    if(stack.peek() == arr[startI][j]){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            rst++;
        }
    }
}
