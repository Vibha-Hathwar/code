/*You are given a 2D matrix mat[][] of size n x m that was initially filled in the following manner:
Each row is sorted in increasing order from left to right.
The first element of every row is greater than the last element of the previous row.
This implies that if the matrix is flattened row-wise, it forms a strictly sorted 1D array.
Later, this sorted 1D array was rotated at some unknown pivot. The rotated array was then written back into the matrix row-wise to form the current matrix.
Given such a matrix mat[][] and an integer x, determine whether x exists in the matrix.*/

class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
                if(x==mat[i][j])
                    return true;
        return false;

    /*
    int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = n * m - 1;
        while (low <= high) 
        {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            int midVal = mat[row][col];

            if (midVal == x)
                return true;

            // Find first element in virtual array
            int first = mat[0][0];

            // Determine which half is sorted
            if (midVal >= first) 
                // Left half is sorted
                if (x >= first && x < midVal)
                    high = mid - 1;
                else
                    low = mid + 1;
            else
                // Right half is sorted
                if (x > midVal && x <= mat[n - 1][m - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
        }

        return false;
    */
    }
}
