package SWEA;

import java.util.*;
import java.io.*;
public class SWEA1204 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int testCaseNum = Integer.parseInt(br.readLine());
            int[] freq = new int[101];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int i=0; i<1000; i++) {
                freq[Integer.parseInt(st.nextToken())]++;
            }
            int rst=0;
            int maxFreq=0;
            for(int i=0; i<=100; i++) {
                if(freq[i]>=maxFreq) {
                    maxFreq=freq[i];
                    rst=i;
                }
            }
            System.out.printf("#%d %d\n", testCaseNum, rst);
        }
    }
}