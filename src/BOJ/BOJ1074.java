package BOJ;
import java.util.*;
import java.io.*;

public class BOJ1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int rst = 0;
        int size = 1 << N;

        while (N > 0) {
            size /= 2;
            if (r < size && c < size) {
            } else if (r < size && c >= size) {
                rst += size * size;
                c -= size;
            } else if (r >= size && c < size) {
                rst += 2 * size * size;
                r -= size;
            } else {
                rst += 3 * size * size;
                r -= size;
                c -= size;
            }
            N--;
        }

        System.out.println(rst);
    }
}
