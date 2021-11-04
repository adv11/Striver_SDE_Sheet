package StriverSDE_Sheet;
/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.



Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

import java.util.Arrays;
import java.util.Scanner;

public class Set_Matrix_Zeros {
    public static void bruteForce(int[][] a){
        // TC = O((n*m) * (n+m))
        // SC = (1)

        // Taking 2 demo array for rows and columns
        int[] d1 = new int[a.length];   // for row
        Arrays.fill(d1, 1);
        int[] d2 = new int[a[0].length];    // for column
        Arrays.fill(d2, 1);

        for(int i=0 ; i<a.length ; i++){
            for (int j = 0; j<a[0].length; j++) {
                if (a[i][j] == 0) {
                    d1[i] = 0;
                    d2[j] = 0;
                }
            }
        }

        for(int i=0 ; i<d1.length ; i++){
            for(int j=0 ; j<d2.length ; j++){
                if(d1[i] == 0 || d2[j] == 0) {
                    a[i][j] = 0;
                }
            }
        }

        for(int i=0 ; i<a.length ; i++){
            for(int j=0 ; j<a[0].length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void optimised(int[][] a){

        // taking col0 for first row
        int col0 = 1, row = a.length, col = a[0].length;
        for(int i=0 ; i<row ; i++){
            if(a[i][0] == 0)    // if first col contains any 0 then storing 0 in col0 variable
                col0 = 0;
            for(int j=1 ; j<col ; j++){ // now checking for the remaining columns if it is 0 then storing 0 in both first ro and col

                if(a[i][j] == 0){
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        // now traversing the array from bottom-right corner of the array
        for(int i=row-1 ; i>=0 ; i--){
            for(int j=col-1 ; j>=1 ; j--){
                if(a[i][0] == 0 || a[0][j] == 0)
                    a[i][j] = 0;
            }
            if(col0 == 0)   // if col0 is zero then it is certain that the first column elements are zero
                a[i][0] = 0;
        }

        for(int i=0 ; i<a.length ; i++){
            for(int j=0 ; j<a[0].length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row:");
        int row = sc.nextInt();
        System.out.println("Enter column:");
        int col = sc.nextInt();

        System.out.println("Enter elements:");
        int[][] a = new int[row][col];
        for(int i=0 ; i<row ; i++)
            for(int j=0 ; j<col ; j++)
                a[i][j] = sc.nextInt();

//        bruteForce(a);
        optimised(a);
    }
}
