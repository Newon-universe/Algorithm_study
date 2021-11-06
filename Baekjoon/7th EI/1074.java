import java.io.*;
import java.util.*;

class Main {
    static int row, col;

    static int[] dx = { 0, 0, 1, 1 };
    static int[] dy = { 0, 1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        divide(0, 0, 0, size);

        br.close();
    }

    private static void divide(int x, int y, int cnt, int size) {
        if (!isBoundary(x, y, size)) {
            return;
        }

        if (size == 2) {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx == row && ny == col) {
                    System.out.println(cnt + i);
                }
            }
            return;
        }

        int newSize = size / 2;
        // 작은 Z 만들기
        divide(x, y, cnt, newSize);
        divide(x, y + newSize, cnt + (newSize * newSize), newSize);
        divide(x + newSize, y, cnt + (newSize * newSize * 2), newSize);
        divide(x + newSize, y + newSize, cnt + (newSize * newSize * 3), newSize);
    }

    private static boolean isBoundary(int x, int y, int size) {
        return (x > row - size && x <= row) && (y > col - size && y <= col);
    }
}