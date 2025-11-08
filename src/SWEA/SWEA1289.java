package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1289 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int rst=0;
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for(int i=0;i<s.length();i++){
                if(stack.isEmpty() && s.charAt(i) == '1'){
                    stack.push('1');
                    rst++;
                }
                if(!stack.isEmpty() && stack.peek() != s.charAt(i)){
                    stack.clear();
                    stack.push(s.charAt(i));
                    rst++;
                }
            }

            System.out.printf("#%d %d\n", test_case, rst);
        }
    }
}
