'''You are given a matrix mat[][] of size n x m, where each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from the top left cell of the matrix to the bottom right cell.
From a cell (i, j), you can only move to cell (i+1, j) or (i, j+1).
Note: It is guaranteed that the answer will not exceed 32-bit integer limits.

Constraints:
1 ≤ k ≤ 100
1 ≤ n, m ≤ 100
0 ≤ mat[i][j] ≤ 200

Examples:
Input: k = 12, mat[] = [[1, 2, 3],
                      [4, 6, 5],
                      [3, 2, 1]]
Output: 2
Explanation: There are 2 possible paths with exactly 12 coins, (1 + 2 + 6 + 2 + 1) and (1 + 2 + 3 + 5 + 1).

Input: k = 16, mat[] = [[1, 2, 3], 
                      [4, 6, 5], 
                      [9, 8, 7]]
Output: 0 
Explanation: There are no possible paths that lead to sum = 16.
'''

class Solution:
    def numberOfPath(self, mat, k):
        # code here
        n = len(mat)
        m = len(mat[0])

        # Use only two 2D arrays for space optimization
        prev = [[0] * (k + 1) for _ in range(m)]
        curr = [[0] * (k + 1) for _ in range(m)]

        # Build DP table iteratively
        for i in range(n):
            for j in range(m):
                for sum_ in range(k + 1):

                    # Base case
                    if i == 0 and j == 0:
                        # Only one way if sum matches cell value
                        curr[j][sum_] = 1 if sum_ == mat[0][0] else 0
                        continue

                    curr[j][sum_] = 0

                    if sum_ - mat[i][j] >= 0:
                        # from top
                        if i > 0:
                            curr[j][sum_] += prev[j][sum_ - mat[i][j]]
                        # from left
                        if j > 0:
                            curr[j][sum_] += curr[j - 1][sum_ - mat[i][j]]

            # Move current row to previous row
            prev = [row[:] for row in curr]

        # Total ways to reach bottom-right with sum = k
        return prev[m - 1][k]
