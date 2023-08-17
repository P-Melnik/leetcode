package arraysandstrings;

public class SpiralArray {

    public static void main(String[] args) {
        int[][] array = spiral(3, 4);
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int k = 0; k < array[0].length; k++) {
                System.out.print(array[i][k] + " ");
            }
        }
    }

    static int[][] spiral(int row, int column) {
        int[][] res = new int[row][column];
        int topRow = 0, bottomRow = row - 1, leftColumn = 0, rightColumn = column - 1;
        int val = 1;
        while (val <= row * column) {
            for (int i = leftColumn; i <= rightColumn && val <= row * column; i++) {
                res[topRow][i] = val++;
            }
            topRow++;
            for (int i = topRow; i <= bottomRow && val <= row * column; i++) {
                res[i][rightColumn] = val++;
            }
            rightColumn--;
            for (int i = rightColumn; i >= leftColumn && val <= row * column; i--) {
                res[bottomRow][i] = val++;
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow && val <= row * column; i--) {
                res[i][leftColumn] = val++;
            }
            leftColumn++;
        }
        return res;
    }
}
