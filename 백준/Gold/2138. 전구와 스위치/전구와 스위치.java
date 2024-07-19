import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][N];

        String[] now = br.readLine().split("");
        String[] goal = br.readLine().split("");

        for (int i = 0; i < N; i++) {
            arr[0][i] = Integer.parseInt(now[i]); // 현재
            arr[1][i] = Integer.parseInt(goal[i]); // 목표
            arr[2][i] = arr[0][i]; // 첫 스위치를 켰을 때 A
            arr[3][i] = arr[0][i]; // 첫 스위치를 껐을 때 B
        }
        // 입력완료

        // 첫 스위치를 켰을 경우 세팅
        toggle(arr, 2,0);
        int A = 1;
        int B = 0;
        int res = Integer.MAX_VALUE;

//        for(int[] d : arr){
//            System.out.println(Arrays.toString(d));
//        }

        for(int i = 1; i<N; i++){
            // 앞의 스위치 상태를 보고 바꾸자
            if(arr[2][i-1] != arr[1][i-1]){
                toggle(arr,2,i);
                A++;
            }
            if(arr[3][i-1] != arr[1][i-1]){
                toggle(arr,3,i);
                B++;
            }

            if(Arrays.equals(arr[1],arr[2])){
                res = Math.min(res, A);
            }
            if(Arrays.equals(arr[1],arr[3])){
                res = Math.min(res, B);
            }
        }

        if(res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);


    }
    // main

    // 스위치 토글
    public static void toggle(int[][] arr, int r, int idx){ // c번째 스위치를 눌렀을 때, 전구변화
        for(int i = idx-1; i<=idx+1; i++){
            if(i >= 0 && i < N){
                if(arr[r][i] == 1) {
                    arr[r][i] = 0;
                }
                else {
                    arr[r][i] = 1;
                }
            }
        }
    }
}