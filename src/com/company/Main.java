package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] area = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}};
        System.out.println("Najwieksza powierzchnia wyspy wynosi= " + largestIslandField(area));
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 34534);
        System.out.println("Para liczb spełniająca warunek to " + returnPair(arrayList, 34535));

    }

    static int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        int area = 1;

        grid[row][col] = 0;

        int[] dir = {-1, 0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int r = row + dir[i], c = col + dir[i + 1];

            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1)
                area += dfs(grid, r, c);
        }
        return area;
    }

    static int largestIslandField(int area[][]) {
        int m = area.length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int n = area[i].length;
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(area, i, j));
            }
        }
        return maxArea;
    }

    public static String returnPair(List<Integer> arrayList, Integer number) {
        ArrayList<Integer> sum = new ArrayList<>();
        for (Integer firstNumber : arrayList) {
            for (Integer secondNumber : arrayList) {
                Integer possibleSum = firstNumber + secondNumber;
                if (possibleSum.equals(number)) {
                    sum.add(firstNumber);
                    sum.add(secondNumber);
                }
            }
            if (!sum.isEmpty()) break;
        }
        if (!sum.isEmpty()) {
            return sum.get(0).toString() + " " + sum.get(1).toString();
        }
        return null;
    }
}
