/*Given a positive integer n, find the minimum number of perfect squares (square of an integer) that sum up to n.
Input: n = 6
Output: 3
Explanation = 1 * 1 + 1 * 1 + 2 * 2 = 6 
*/
class Solution {
  public:
    int minSquares(int n) {
        // Code here
        vector<int> dp(n+1,1e9);
        dp[0]=0;
        for(int i=1;i<=n;i++)
            for(int j=1;j*j<=i;j++)
                dp[i]=min(dp[i], 1+dp[i-j*j]);
        return dp[n];
        
        // int ans;
        // int dp[10001];
        // if(n==1)
        //     return 1;
        // dp[1] = 1;
        // dp[2] = 2;
        // for(int i=3;i<=n;i++)
        // {
        //     dp[i] = 10001;
        //     for(int j=1;j*j<=i;j++)
        //         dp[i] = min(dp[i], 1+dp[i-j*j]);
        // }
        // ans = dp[n];
        // return ans;
    //  use one square j*j, and find the minimum number of squares for the remaining part i - j*j.    
    //  For n = 12:
    //  Possible combinations:
    //     4 + 4 + 4 → 3 squares
    //     9 + 1 + 1 + 1 → 4 squares
    //      minimum=3 - > dp[12]=3
    }
};
