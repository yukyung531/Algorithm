import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 노드 개수
        int N = sc.nextInt();

        // 리스트를 원소로 가지는 배열
        List<Integer>[] list = new ArrayList[N + 1];

        // 초기화
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        int[] arr = new int[N+1];

        boolean[] visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < list[curr].size(); i++) {
                if (!visited[list[curr].get(i)]) {
                    q.add(list[curr].get(i));
                    visited[list[curr].get(i)] = true;
                    if (arr[list[curr].get(i)] == 0) {
                        arr[list[curr].get(i)] = curr;
                    }
                }
            }
        }
        // while

        for(int i = 2; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    // main
}
