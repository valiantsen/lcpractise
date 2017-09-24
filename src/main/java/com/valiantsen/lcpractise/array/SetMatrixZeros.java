package main.java.com.valiantsen.lcpractise.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * @ClassName: SetMatrixZeros
 * @author zhangyasen
 * @date 2017年9月23日
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix ==null ||matrix.length==0) return;
        int m = matrix.length;
        int n =matrix[0].length;
        if(n== 0 ) return;
        Set<Integer> rows = new HashSet<>(m);
        Set<Integer> columns = new HashSet<>(n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rows.contains(i)||columns.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public void setZeroesLC(int[][] matrix) {
        if(matrix ==null ||matrix.length==0) return;
        int m = matrix.length;
        int n =matrix[0].length;
        if(n== 0 ) return;
        boolean row0=false,column0=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0) row0=true;
                    if(j==0) column0=true;
                    matrix[i][0] = matrix[0][j] =0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
             
                if( matrix[i][0] ==0 || matrix[0][j]==0 ){
                     matrix[i][j]=0;
                }
            }
        }
        if(row0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(column0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        SetMatrixZeros sm = new SetMatrixZeros();
        int[][] a = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        sm.setZeroesLC(a);
    }
}
