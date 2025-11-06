package BOJ;
import java.util.*;
import java.io.*;

public class BOJ1753 {
    static int[] visited = new int[20001];
    static int MAX_NUM = 210000000;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(br.readLine());
        List<graph> graph = new ArrayList<>();
        for(int i=0;i<V+1;i++){
            graph.add(new graph(i));
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).list.add(new pathValue(e, w));
        }

        int[] rst = new int[V+1];
        for(int i=0;i<V+1;i++){
            rst[i] = MAX_NUM;
            if(i == startV){
                rst[i] = 0;
            }
        }

        for(int i=0;i<V+1;i++){
            int index = search(rst, V+1);
            if(rst[index] == MAX_NUM){
                break;
            }
            graph tem = graph.get(index);
            for(int j=0;j<tem.list.size();j++){
                if(rst[tem.list.get(j).path] > rst[index] + tem.list.get(j).value){
                    rst[tem.list.get(j).path] = rst[index] + tem.list.get(j).value;
                }
            }
            visited[index] = 1;
        }

        for(int i=1;i<=V;i++) {
            if (rst[i] == MAX_NUM) {
                System.out.println("INF");
            } else {
                System.out.println(rst[i]);
            }
        }


    }

    static class graph{
        int id;
        List<pathValue> list = new ArrayList<>();
        public graph(int i){
            this.id = i;
        }
    }

    static class pathValue{
        int path;
        int value;

        public pathValue(int path, int value){
            this.path = path;
            this.value = value;
        }
    }

    static int search(int[] arr, int len){
        int min = MAX_NUM;
        int index = -1;
        for(int i=1;i<len;i++){
            if(arr[i] <= min && visited[i] == 0){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
