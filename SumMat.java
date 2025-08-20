/*A matrix is constructed of size n*n and given an integer ‘q’. The value at every cell of the matrix is given as, M(i,j) = i+j, where ‘M(i,j)' is the value of a cell, 
‘i’ is the row number, and ‘j’ is the column number. Return the number of cells having value ‘q’.
Note: Assume, the array is in 1-based indexing.*/

class Solution {
    static long sumMatrix(long n, long q) {
        // code here
        long low = Math.max(1, q - n);
        long high = Math.min(n, q - 1);
        if (low > high)
            return 0;
        return high - low + 1;

/* if(q <= n + 1)
            return q - 1;
        else if(q > n*2)
            return 0;
        else
            return (n + 1) - (q - (n + 1)) - 1;
            //return 2 * n + 1 - q;
*/
    }
}
