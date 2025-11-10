package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for(int test_case=1;test_case<=T;test_case++){
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<8;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int index = 0;
            int minusValue = 1;
            while(true){
                arr[index] -= minusValue;
                if(arr[index] <= 0){
                    arr[index] = 0;
                    System.out.printf("#%d ", t);
                    for(int i=index+1;i<8;i++){
                        System.out.print(arr[i] + " ");
                    }
                    for(int i=0;i<index+1;i++){
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                }
                index++;
                minusValue++;
                if(index > 7){
                    index -= 8;
                }
                if(minusValue > 5){
                    minusValue -= 5;
                }
            }
        }

    }
}
