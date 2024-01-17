import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 철수 빙고판
        int[][] cheolsu = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cheolsu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙고 횟수
        int bingo = 0;

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());


                // 철수 빙고판에서 num 찾아서 체크(0으로 변경)
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (cheolsu[k][l] == num) {
                            cheolsu[k][l] = 0;
                        }
                    }
                }

                // 숫자를 지우기 전에 빙고 확인
                bingo = checkBingo(cheolsu);
                if (bingo >= 3) {
                    System.out.println((5 * (i - 1)) + j);
                    return;
                }

            }
        }
    }
    //main
    public static int checkBingo(int[][] board) {
        int bingo = 0;
        // 가로, 세로, 대각선 확인
        for (int i = 0; i < 5; i++) {
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0 && board[i][3] == 0 && board[i][4] == 0) bingo++;
            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0 && board[3][i] == 0 && board[4][i] == 0) bingo++;
        }

        // 대각선 확인
        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0 && board[4][4] == 0) bingo++;
        if (board[0][4] == 0 && board[1][3] == 0 && board[2][2] == 0 && board[3][1] == 0 && board[4][0] == 0) bingo++;

        return bingo;
    }
}
