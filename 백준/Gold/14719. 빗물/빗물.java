import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] block = new int[H][W];

        st = new StringTokenizer(br.readLine());
        int bottom = 500;

        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());

            for (int j = 0; j < height; j++) {
                block[j][i] = 1; // 블록 표시
            }

            bottom = Math.min(bottom, height);
        }

        int total = 0;
        for (int i = bottom; i < H; i++) {
            boolean flag = false;
            int sum = 0;
            for (int j = 0; j < W; j++) {
                if (block[i][j] == 1) { // 벽 만나면
                    flag = true;
                }

                if (flag && block[i][j] == 0) {
                    sum++;
                }

                if (sum > 0 && block[i][j] == 1) {
                    total += sum;
                    sum = 0;
                }
            }
            // j
        }
        // i

        System.out.println(total);
    }
    // main
}