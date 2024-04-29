import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 국가 수
        int K = sc.nextInt(); // 등수가 궁금한 국가

        int[][] input = new int[N][4]; // 국가, 금은동 입력
        int[] rank = new int[N+1];

        for(int i = 0; i<N; i++){
            input[i][0] = sc.nextInt(); // 국가
            input[i][1] = sc.nextInt(); // 금
            input[i][2] = sc.nextInt(); // 은
            input[i][3] = sc.nextInt(); // 동
        }

        Arrays.sort(input, (a, b) -> {
            // 먼저 [i][1]을 비교
            if (a[1] != b[1]) {
                return -Integer.compare(a[1], b[1]);
            }
            // [i][1]이 같다면, [i][2]를 비교
            if (a[2] != b[2]) {
                return -Integer.compare(a[2], b[2]);
            }
            // [i][2]도 같다면, [i][3]을 비교
            return -Integer.compare(a[3], b[3]);
        });

//        // 정렬된 배열 출력
//        for (int[] row : input) {
//            System.out.println(Arrays.toString(row));
//        }

        int now = 1; // 1등부터 시작
        rank[input[0][0]] = 1;
        for(int i = 1; i<N; i++){
            // 금은동 모두 같다면 같은 등수
            if(input[i][1] == input[i-1][1] && input[i][2] == input[i-1][2] && input[i][3] == input[i-1][3]){
                rank[input[i][0]] = now;
            }
            else{
                now++;
                rank[input[i][0]] = now;
                continue;
            }
            now++;
        }

        System.out.println(rank[K]);

    }
    // main
}
