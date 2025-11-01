package SWEA;
import java.util.*;
import java.io.*;

public class SWEA1859 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> top = new ArrayList<>();
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            long rst = 0;

            for(int i=0;i<n;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=1;i<n-1;i++){
                if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1)){
                    top.add(i);
                }
            }
            if(list.get(n-2)<=list.get(n-1)){
                top.add(n-1);
            }

            int max = -1;
            int maxIndex = -1;
            int head = -1;
            int li;
            while(head < n) {
                max = -1;
                for (li = 0; li < top.size(); li++) {
                    if (max < list.get(top.get(li))) {
                        max = list.get(top.get(li));
                        maxIndex = li;
                    }
                }
                for (int j = 0; j < maxIndex - 1; j++) {
                    top.removeFirst();
                }

                if(top.isEmpty()){
                    break;
                }
                for (int i = 0; i < top.get(0); i++) {
                    rst += list.get(top.get(0)) - list.get(i);
                }
                head = top.get(0) + 1;
                top.removeFirst();

            }

            System.out.printf("#%d %d\n",test_case ,rst);
        }

    }
}
