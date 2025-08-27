/*Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 
A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:
Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  

Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300].

Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible.*/

class Solution {
    public int countTriangles(int arr[]) {
        // code here
        int n = a.length;
        Arrays.sort(a);
        int k, sum, cnt = 0;
        for(int i = 0; i < (n-2); i++)
        {
            k = i + 2;
            for(int j = i + 1; j < (n-1); j++)
            {
                sum = a[i] + a[j];

                while((k < n) && (a[k] < sum))
                    k++;
                if(k == n) 
                {
                    cnt += ((n-j-1)*(n-j)) / 2;
                    break;
                }
                if(k == j) 
                    k++;
                cnt += (k - j - 1);
            }
        }
        return cnt;
    }
}

//Count triplets (i < j < k) so that a[i] + a[j] > a[k] (triangle inequality).
/*
Sort the array and use two pointers. Fix two smaller sides (i, j) and move a third pointer k forward to find how many possible third sides satisfy a[i] + a[j] > a[k].

Steps :
1. Sort the array — this ensures a[i] ≤ a[j] ≤ a[k].
2. Fix i from 0 to n-3. Initialize k = i + 2.
3. For each j = i+1 .. n-2:
   - Move k forward while (k < n && a[k] < a[i] + a[j]) 
   - Indices (j+1 .. k-1) are valid third sides → add (k - j - 1) to count 
   - If k reaches n, then remaining j' > j produce counts:
     (n-j-1), (n-j-2), ... , 1 — their sum is the triangular number
     (n-j-1) * (n-j) / 2. Add it and break the j-loop to skip redundant work 
4. Edge check: if k == j, do k++ to ensure k > j (third index must be strictly after j).*/
