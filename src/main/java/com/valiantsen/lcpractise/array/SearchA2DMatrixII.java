package main.java.com.valiantsen.lcpractise.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in each column are
 * sorted in ascending from top to bottom. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26,
 * 30] ] Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 * 
 * @ClassName: SearchA2DMatrixII
 * @author zhangyasen
 * @date 2017年9月14日
 */
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 0)
            return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (column >= 0 && row < matrix.length) {
            int temp = matrix[row][column];
            if (temp == target) {
                return true;
            }
            if (temp > target) {
                column--;
            }
            if (temp < target) {
                row++;
            }
        }

        return false;
    }
}
