import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, P, X;
    static int cnt;
    static int[][] display;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 총 층의 수
        K = Integer.parseInt(st.nextToken()); // 자릿 수
        P = Integer.parseInt(st.nextToken()); // 최대 반전 개수
        X = Integer.parseInt(st.nextToken()); // 현재 수

        display = new int[][]{
                {1, 1, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1}
        };

        int[] nums = new int[K];
        int x = X;
        for (int i = K - 1; i >= 0; i--) {
            nums[i] = x % 10;
            x /= 10;
        }
        check(nums);

        System.out.println(cnt);


    }

    // main
    public static void check(int[] nums) {
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (convert(nums, i)) cnt++;
        }
    }
    // check : 바꿀 수 있는 숫자인지 확인

    public static boolean convert(int[] nums, int compare) {
        int[] tmp = new int[K];// 바꿀 수 있는지 확인할 숫자
        for (int i = K - 1; i >= 0; i--) {
            tmp[i] = compare % 10;
            compare /= 10;
        }
        int diff = 0; // 전환횟수
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if (display[tmp[i]][j] != display[nums[i]][j]) diff++;
                if (diff > P) return false;
            }
        }
        return true;
    }
    // 전환 가능한지 확인
}