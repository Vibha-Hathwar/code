'''Given two strings pat and txt which may be of different sizes, You have to return true if the wildcard pattern i.e. pat, matches with txt else return false.
The wildcard pattern pat can include the characters '?' and '*'.
    '?' – matches any single character.
    '*' – matches any sequence of characters (including the empty sequence).
Note: The matching should cover the entire txt (not partial txt).

Constraints:
1 ≤ txt.size(), pat.size() ≤ 100

Examples:

Input: txt = "abcde", pat = "a?c*"
Output: true
Explanation: '?' matches with 'b' and '*' matches with "de".

Input: txt = "baaabab", pat = "a*ab"
Output: false
Explanation: The pattern starts with a, but the text starts with b, so the pattern does not match the text.
'''

class Solution:
    def wildCard(self, txt, pat):
        # code here
        n, m = len(txt), len(pat)
        # dp[i][j] = True if first i chars of txt match first j chars of pat
        dp = [[False] * (m + 1) for _ in range(n + 1)]
        # Empty pattern matches empty text
        dp[0][0] = True
        # can match empty string, so fill first row
        for j in range(1, m + 1):
            if pat[j - 1] == '*':
                dp[0][j] = dp[0][j - 1]
        # Fill the dp table
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if pat[j - 1] == txt[i - 1] or pat[j - 1] == '?':
                    dp[i][j] = dp[i - 1][j - 1]
                elif pat[j - 1] == '*':
                    # '*' -> match empty (dp[i][j-1]) OR match one more char (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] or dp[i - 1][j]
                else:
                    dp[i][j] = False
        return dp[n][m]
      
      '''n, m = len(txt), len(pat)    #0.04
        dp = [[False]*(n+1) for _ in range(m+1)]
        dp[0][0] = True

        for i in range(1, m+1):
            dp[i][0] = pat[i-1] == '*' and dp[i-1][0]

        for i in range(1, m+1):
            for j in range(1, n+1):
                if pat[i-1] in ('?', txt[j-1]):
                    dp[i][j] = dp[i-1][j-1]
                elif pat[i-1] == '*':
                    dp[i][j] = dp[i-1][j] or dp[i][j-1]
        return dp[m][n]'''
