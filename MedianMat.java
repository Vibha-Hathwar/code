/*Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.
Examples:
Input: mat[][] = [[1, 3, 5], 
                [2, 6, 9], 
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.*/

class Solution {
    
     private int countSmallerEqual(int[] row, int target) 
     {
        int low = 0, high = row.length;
        while (low < high)
        {
            int mid = (low + high) / 2;
            if (row[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    public int median(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) 
        {
            minVal = Math.min(minVal, mat[i][0]); //min among 1st col
            maxVal = Math.max(maxVal, mat[i][C - 1]); //max among last col
        }
        int desired = (R * C + 1) / 2;

        while (minVal < maxVal) 
        {
            int mid = (minVal + maxVal) / 2;
            int count = 0;

            for (int i = 0; i < R; i++)
                count += countSmallerEqual(mat[i], mid); // how many elements are lesser than mid
            if (count < desired)
                minVal = mid + 1;
            else
                maxVal = mid;
        }
        return minVal;
    }
}

//Binary search inside each row to count values ≤ mid
/*
itertion
mat=[ [1 3 5]  [2 6 9]  [3 6 9]]
while(1<9)
{
  mid=5;
  for count=5
  else max=5
}
while(1<5)
{
  mid=3;
  for count = 4
  if min=4
}
while(4<5)
{
  mid=4;
  for count=4
  if min=5
}
return 5;
*/
