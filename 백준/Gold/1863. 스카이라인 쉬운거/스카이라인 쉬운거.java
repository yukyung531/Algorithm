import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int x, y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) { // x 기준 오름차순 정렬
                return o1.x- o2.x <= 0 ? -1 : 1;
            }
        });

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x,y));
        }

        boolean[] visited = new boolean[N];
        int cnt = 0;

        for(int i = 0; i<N; i++){
            if(!visited[i]){
                int now = list.get(i).y; // 현재 건물의 높이
                if(now == 0) continue;
                int end = 0; // 끝나는 건물의 위치
                for(int j = i; j<N; j++){
                    if(list.get(j).y == now) visited[j] = true;
                    if(list.get(j).y < now) {
                        end = j-1; // 현재 높이의 건물 끝
                        break;
                    }
                }
                cnt++; // 건물 수 증가
//                System.out.println(Arrays.toString(visited));
            }
        }
        System.out.println(cnt);


    }
    // main
}