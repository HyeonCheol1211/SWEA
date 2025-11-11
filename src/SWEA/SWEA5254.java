package SWEA;
import java.util.*;
import java.io.*;

public class SWEA5254 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            HashSet<String> hash = new HashSet<>();
            for(int len=1;len<=s.length();len++){
                for(int i=0;i<s.length()-len+1;i++){
                    String subString = s.substring(i, i+len);
                    hash.add(subString);
                }
            }

            List<String> list = new ArrayList<>(hash);
            Collections.sort(list);

            System.out.printf("#%d %c %d\n", test_case, list.get(N-1).charAt(0), list.get(N-1).length());

        }
    }
}
