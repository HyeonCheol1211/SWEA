package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case=1;test_case<=T;test_case++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int[] arr = new int[100];
            for(int i=0;i<100;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int rst = dump(arr, n);
            System.out.printf("#%d %d\n", test_case, rst);
        }
    }

    static class Set{
        int value;
        int index;

        Set(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static Set maxSet(int[] arr){
        int value = 0;
        int index = -1;
        for(int i=0;i<100;i++){
            if(arr[i]>value){
                value = arr[i];
                index = i;
            }
        }
        Set rstSet = new Set(value, index);
        return rstSet;
    }


    public static Set minSet(int[] arr){
        int value = 101;
        int index = -1;
        for(int i=0;i<100;i++){
            if(arr[i]<value){
                value = arr[i];
                index = i;
            }
        }
        Set rstSet = new Set(value, index);
        return rstSet;
    }


    public static int dump(int[] arr, int n){
        for(int i=0;i<n;i++) {
            Set maxSet = maxSet(arr);
            Set minSet = minSet(arr);
            arr[maxSet.index]--;
            arr[minSet.index]++;
        }
        Set maxSet = maxSet(arr);
        Set minSet = minSet(arr);
        return maxSet.value - minSet.value;
    }
}
