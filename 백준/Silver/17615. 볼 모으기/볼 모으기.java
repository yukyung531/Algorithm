import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();

        List<List<Character>> ballList = new ArrayList<>();
        ballList.add(new ArrayList<>());

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (i != 0 && ballList.get(idx).get(0) != balls[i]) { // 처음 입력받은 공이 아니고, 새로 입력받은 볼이 직전에 입력받은 볼과 다른 색이라면
                // 새로운 리스트 생성
                ballList.add(new ArrayList<>());
                // idx 증가
                idx++;
            }
            // 입력받은 볼 추가
            ballList.get(idx).add(balls[i]);
        }

//        for (List<Character> list : ballList) {
//            for (Character c : list) {
//                System.out.print(c);
//            }
//            System.out.println();
//        }


        // 만약 한가지 색의 볼만 받았다면
        if (idx == 0) {
            System.out.println(0);
            return;
        }

        // R을 움직일 경우랑 B를 움직일 경우의 수를 비교
        int res = Integer.MAX_VALUE;
        int move = 0;
        char color = 'R'; // 일단 임의의 값 넣어두자.

        // 맨 앞으로 이동할 경우와 맨 뒤로 이동할 경우의 수를 확인
        // B를 맨 뒤로 이동
        for (int i = ballList.size() - 1; i >= 0; i--) {
            if (i != idx && ballList.get(i).get(0) != color) { // 마지막 idx가 아니고, 'B'라면
                move += ballList.get(i).size(); // 이동
            } else if (i == idx && ballList.get(i).get(0) != color) { // 마지막 idx이고, 'B'라면
                continue;
            }
        }
        res = Math.min(res, move);
        move = 0;

        // B를 맨 앞으로 이동
        for (int i = 0; i < ballList.size(); i++) {
            if (i == 0 && ballList.get(i).get(0) != color) { // i == 0이고, 'B'라면 그대로.
                continue;
            } else if (i != 0 && ballList.get(i).get(0) != color) { // i != 0이고, 'B'라면, 이동
                move += ballList.get(i).size(); // 이동
            }
        }
        res = Math.min(res, move);
        move = 0;

        color = 'B';

        // R을 맨 뒤로 이동
        for (int i = ballList.size() - 1; i >= 0; i--) {
            if (i != idx && ballList.get(i).get(0) != color) { // 마지막 idx가 아니고, 'R'이라면
                move += ballList.get(i).size(); // 이동
            } else if (i == idx && ballList.get(i).get(0) != color) {// 마지막 idx 이고, 'R'이라면
                continue;
            }
        }
        res = Math.min(res, move);
        move = 0;

        // R을 맨 앞으로 이동
        for (int i = 0; i < ballList.size(); i++) {
            if (i != 0 && ballList.get(i).get(0) != color) { // 첫 인덱스가 아니고, 'R'이라면
                move += ballList.get(i).size(); // 이동
            } else if (i == 0 && ballList.get(i).get(0) != color) { // 첫 인덱스이고, 'R'이라면
                continue;
            }
        }
        res = Math.min(res, move);
        System.out.println(res);

    }
    // main
}