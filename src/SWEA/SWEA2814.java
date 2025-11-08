package SWEA;
import java.util.*;
import java.io.*;

public class SWEA2814 {
    static int rst = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Node> list = new ArrayList<>();
            boolean[] check = new boolean[N+1];
            List<Integer> rstList = new ArrayList<>();
            for(int i=0;i<N+1;i++){
                list.add(new Node());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).linkedNodes.add(y);
                list.get(y).linkedNodes.add(x);
            }
            for(int i=1;i<=N;i++) {
                dfs(list, check, i, rstList);
                for(int j=0;j<N+1;j++){
                    check[j] = false;
                }
                rstList.clear();
            }
            System.out.printf("#%d %d\n", test_case, rst);
            rst = 0;
        }
    }

    static void dfs(List<Node> list, boolean[] check, int index, List<Integer> rstList){
        rstList.add(index);
        check[index] = true;

        boolean isEnd = true;
        for(int i=0;i<list.get(index).linkedNodes.size();i++){
            if(!check[list.get(index).linkedNodes.get(i)]){
                isEnd = false;
            }
        }
        if(isEnd) {
//            for(int i=0;i<rstList.size();i++){
//                System.out.printf(rstList.get(i) + " ");
//            }
//            System.out.println("");

            rst = Math.max(rstList.size(), rst);

            rstList.remove(rstList.size()-1);
            check[index] = false;
            return;
        }


        for(int i=0;i<list.get(index).linkedNodes.size();i++){

            if(!check[list.get(index).linkedNodes.get(i)]){
                dfs(list, check, list.get(index).linkedNodes.get(i), rstList);
            }
        }

        rstList.remove(rstList.size()-1);
        check[index] = false;
    }

    static class Node{
        List<Integer> linkedNodes = new ArrayList<>();
        public Node(){

        }
    }
}
