package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1244 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<T+1;test_case++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String strNum = st.nextToken();
            int length = strNum.length();
            int switchCnt = Integer.parseInt(st.nextToken());
            if(switchCnt==0){
                System.out.println(strNum);
                continue;
            }
            int[] numArr = new int[6];
            for(int i=0;i<strNum.length();i++){
                numArr[i] = strNum.charAt(i) - '0';
            }
            boolean lastSwitch = false;
            ArrayList<Integer>[] switchValue = new ArrayList[10];
            ArrayList<Integer>[] switchOfSwitch = new ArrayList[10];
            for(int i=0;i<10;i++){
                switchValue[i] = new ArrayList<>();
                switchOfSwitch[i] = new ArrayList<>();
            }
            int searchHead = 0;
            while(switchCnt>0){
                int maxNum = -1;
                int switchIndex = -1;
                for(int i=searchHead;i<length;i++){
                    if(maxNum <= numArr[i]){
                        maxNum = numArr[i];
                        switchIndex = i;
                    }
                    if(i==length-1 && maxNum == numArr[searchHead]){
                        searchHead++;
                        i = searchHead-1;
                        maxNum = -1;
                    }
                }
                if(searchHead == length){
                    if(switchCnt%2 == 1) {
                        lastSwitch = true;
                    }
                    break;
                }
                int tem = numArr[switchIndex];
                numArr[switchIndex] = numArr[searchHead];
                numArr[searchHead] = tem;
                switchOfSwitch[numArr[searchHead]].add(switchIndex);
                switchValue[numArr[searchHead]].add(numArr[switchIndex]);
                switchCnt--;
                searchHead++;
            }
            for(int i=0;i<10;i++) {
                Collections.sort(switchValue[i], Collections.reverseOrder());
                Collections.sort(switchOfSwitch[i]);
            }
            for(int j=9;j>=0;j--) {
                for (int i = 0; i < switchValue[j].size(); i++) {
                    numArr[switchOfSwitch[j].get(i)] = switchValue[j].get(i);
                }
            }

            if(lastSwitch&&length>1) {
                boolean sameNum = false;
                for(int i=0;i<length-1;i++){
                    if(numArr[i]==numArr[i+1]){
                        sameNum = true;
                    }
                }
                if(!sameNum) {
                    int tem = numArr[length - 1];
                    numArr[length - 1] = numArr[length - 2];
                    numArr[length - 2] = tem;
                }
            }
            System.out.printf("#%d ", test_case);
            for(int i=0;i<length;i++){
                System.out.print(numArr[i]);
            }
            System.out.println();

        }

    }
}
