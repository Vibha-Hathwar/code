'''
You are given a 2D array mat[][], of size n*m. Your task is to find the minimum possible path cost from the top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent cells.
Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive cells along that path.

Constraints:
1 ≤ n, m ≤ 100
0 ≤ mat[i][j] ≤ 106

Examples:
Input: mat[][] = [[7, 2, 6, 5],
               [3, 1, 10, 8]]
Output: 4
Explanation: The route of [7, 3, 1, 2, 6, 5, 8] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 4.

Input: mat[][] = [[2, 2, 2, 1],
               [8, 1, 2, 7],
               [2, 2, 2, 8],
               [2, 1, 4, 7],
               [2, 2, 2, 2]]
Output: 0
Explanation: The route of [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 0.

'''
class Solution:
    def minCostPath(self, mat):
        # code here
        from heapq import heappop, heappush
        m, n = len(mat), len(mat[0])
        MAX_EFFORT = 10**6 * m * n
        DIRS = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        h = [(0, 0, 0)]
        while h:
            effort, x, y = heappop(h)
            if mat[x][y] == MAX_EFFORT:
                continue
            if x == m - 1 and y == n - 1:
                return effort
            for dx, dy in DIRS:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    new_effort = max(effort, abs(mat[x][y] - mat[nx][ny]))
                    heappush(h, (new_effort, nx, ny))
            mat[x][y] = MAX_EFFORT
        
