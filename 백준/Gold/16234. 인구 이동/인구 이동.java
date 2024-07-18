import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 완료

        int res = 0;

        while (true) { // 인구 이동 가능하면 이동
            boolean isMoved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (move(i, j, arr, visited))
                            isMoved = true;
                    }
                }
            }
            if (!isMoved) break;

            res++;
        }
        System.out.println(res);

    }

    // main

    public static boolean move(int i, int j, int[][] arr, boolean[][] visited) {

        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> union = new ArrayDeque<>();
        q.add(new Node(i, j));
        union.add(new Node(i, j));
        visited[i][j] = true;

        int sum = arr[i][j];
        int cnt = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                // 범위 안에 있고, 두 값의 차를 만족하고, 방문하지 않았다면
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC]) {
                    int diff = Math.abs(arr[now.r][now.c] - arr[nextR][nextC]);
                    if (diff >= L && diff <= R) {
                        q.add(new Node(nextR, nextC));
                        union.add(new Node(nextR, nextC));
                        visited[nextR][nextC] = true;
                        sum += arr[nextR][nextC];
                        cnt++;
                    }
                }
            }
        }
        // while


        if (cnt > 1) { // 인구 이동 발생
            int newSum = sum / cnt;
            while (!union.isEmpty()) {
                Node n = union.poll();
                arr[n.r][n.c] = newSum;
            }
            return true;

        }
        return false;

    }
}
/*
3 3 4
6 8 5
10 7 2
9 10 1
 */