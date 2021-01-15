package com.shuhai;

public class ShipsCounter {
    static int[][] ships = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0,},
            {0, 1, 0, 1, 1, 0, 0, 1, 1, 1,},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {1, 1, 1, 1, 0, 1, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0,},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1,}
    };
    static final int ROW = 10, COL = 10;

    static boolean isSafe(int[][] M, int row, int col,
                          boolean[][] visited) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    static void DFS(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowNbr = new int[]{-1, 0, 0, 1};
        int[] colNbr = new int[]{0, -1, 1, 0};

        visited[row][col] = true;

        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }


    public static void main(String[] args) {
        int count = 0;
        boolean[][] visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (ships[i][j] == 1 && !visited[i][j]) {
                    DFS(ships, i, j, visited);
                    ++count;
                }
        System.out.println(count);
    }
}