import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// bfs 써서 다시 풀자
public class Main {
    public static class Node {
        int X;
        int time;

        public Node(int X, int time) {
            this.X = X;
            this.time = time;
        }
    }

    public static Queue<Node> q;
    public static int res = Integer.MAX_VALUE;
    public static int max = 100000;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];

        int a = (int) 3.3F;
        long b = 2;

        int result = 0;

        q = new ArrayDeque<>();
        q.offer(new Node(N, 0));
        bfs(K);
    }
    // main

    public static void bfs(int K) {
        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.X] = true;
            if (node.X == K) {
                res = Math.min(res, node.time);
                System.out.println(res);
                return;
            }
            if (node.X * 2 <= max && !visited[node.X * 2]) {
                q.offer(new Node(node.X * 2, node.time));
            }
            if (node.X - 1 <= max && node.X -1 >= 0 && !visited[node.X - 1]) {
                q.offer(new Node(node.X - 1, node.time + 1));
            }
            if (node.X + 1 <= max && !visited[node.X + 1]) {
                q.offer(new Node(node.X + 1, node.time + 1));
            }

        }
    }
    // bfs

}