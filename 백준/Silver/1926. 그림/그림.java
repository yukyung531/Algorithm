import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Node {
        // 도화지의 좌표
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 도화지 세로, 가로
    static int n, m;
    // 도화지 배열
    static int[][] paper;
    // 그림 개수
    static int cnt;
    // 그림 max 넓이
    static int maxSize;
    // 그림 넓이
    static int artSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 도화지 세로
        n = sc.nextInt();
        // 도화지 가로
        m = sc.nextInt();

        // 도화지 배열
        paper = new int[n][m];

        // 그림 정보 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        // 그림 개수
        cnt = 0;
        // 그림 넓이
        maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그림을 만나면 bfs탐색
                if (paper[i][j] == 1) {
                    bfs(new Node(i, j));
                    cnt++;
                    // 가장 넓은 그림 넓이 갱신
                    if(maxSize < artSize){
                        maxSize = artSize;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);

    }
    // main
    public static void bfs(Node node) {
        artSize = 0;
        // 우하좌상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        Queue<Node> q = new ArrayDeque<>();

        // 시작 위치 넣기
        q.add(node);
        // 그림 넓이 +1
        artSize++;
        // 해당 도화지 좌표값을 0으로 바꾸기
        paper[node.r][node.c] = 0;

        while (!q.isEmpty()) {
            Node next = q.poll();
            // 델타탐색하며
            for (int d = 0; d < 4; d++) {
                int nextR = next.r + dr[d];
                int nextC = next.c + dc[d];

                // 다음 좌표가 도화지 안에 있고, 값이 1이면 q에 넣고 그림 넓이 +1
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && paper[nextR][nextC] == 1) {
                    q.add(new Node(nextR, nextC));
                    artSize++;
                    paper[nextR][nextC] = 0;
                }
            }
        }
    }
    //bfs
}
