package SWEA;

import java.util.*;
import java.io.*;

public class SWEA25330 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int indexOfArr = 0;
            int[] arr = new int[20];
            int[] checkArr = new int[10];
            int rst=1;
            for(int j=-0;j<20;j++){
                arr[j] = 0;
            }
            while(a>0){
                arr[indexOfArr] = a%10;
                a /= 10;
                indexOfArr++;
            }
            for(int j=0;j<indexOfArr;j++){
                if(checkArr[arr[j]]==0){
                    checkArr[arr[j]]++;
                    if(arr[j+arr[j]+1] != arr[j]){
                        rst = 0;
                    }
                }else{
                    checkArr[arr[j]]++;
                }
            }
            for(int k=0;k<10;k++){
                if(checkArr[k]==0 || checkArr[k]==2){
                    continue;
                }else{
                    rst = 0;
                }
            }

            if(rst==1){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }



        }

    }
}
