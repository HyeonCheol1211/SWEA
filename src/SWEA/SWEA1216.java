package SWEA;
import java.util.*;
import java.io.*;
public class SWEA1216 {
    static int maxLen = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case=1;test_case<=T;test_case++){
            int t = Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];
            String s;
            for(int j=0;j<100;j++){
                s = br.readLine();
                for(int i=0;i<100;i++){
                    arr[i][j] = s.charAt(i);
                }
            }


            for(int i=0;i<100;i++){
                updateLen(arr, i, 0);
                updateLen(arr, i, 1);
            }

            System.out.printf("#%d %d\n", t, maxLen);
            maxLen = 1;
        }
    }

    static void updateLen(char[][] arr, int index, int dir){
        char[] temArr = new char[100];
        if(dir == 0){
            for(int i=0;i<100;i++){
                temArr[i] = arr[i][index];
            }
        }else if(dir == 1){
            for(int i=0;i<100;i++){
                temArr[i] = arr[index][i];
            }
        }else{
            System.out.println("방향 설정 에러");
            return;
        }

        for(int len=2;len<=100;len++){
            palindrome(temArr, len);
        }
    }

    static void palindrome(char[] arr, int len){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<=100-len;i++){
            for(int si=i;si<i+len/2;si++){
                stack.push(arr[si]);
            }
            int si = (len%2 == 0) ? i+len/2 : i+1+len/2;
            for(;si<i+len;si++){
                if(stack.peek() == arr[si]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                maxLen = Math.max(maxLen, len);
                return;
            }
            stack.clear();
        }
    }
}
