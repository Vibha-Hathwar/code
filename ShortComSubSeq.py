'''Shortest Common Supersequence
Difficulty: MediumAccuracy: 55.62%Submissions: 139K+Points: 4

Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.
Note: s1 and s2 can have both uppercase and lowercase English letters.

Constraints:
1 ≤ s1.size(), s2.size() ≤ 500

Examples:

Input: s1 = "geek", s2 = "eke"
Output: 5
Explanation: String "geeke" has both string "geek" and "eke" as subsequences.

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 9
Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.

Input: s1 = "geek", s2 = "ek"
Output: 4
Explanation: String "geek" has both string "geek" and "ek" as subsequences.
'''
class Solution:
    def minSuperSeq(self, X, Y):
        # code here
        n, m = len(X), len(Y)
        # Create DP table for LCS
        dp = [[0] * (m + 1) for _ in range(n + 1)]
        # Fill DP table
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if X[i - 1] == Y[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        lcs_length = dp[n][m]
        # Length of Shortest Common Supersequence
        return n + m - lcs_length
