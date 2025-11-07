'''Given a 2D array jobs[][] of size n × 3, where each row represents a single job with the following details:
    jobs[i][0] : Start time of the job
    jobs[i][1] : End time of the job
    jobs[i][2] : Profit earned by completing the job
Find the maximum profit you can earn by scheduling non-overlapping jobs.
Note: Two jobs are said to be non-overlapping if the end time of one job is less than or equal to the start time of the next job. If a job ends at time X, another job can start exactly at time X.

Constraints:
1 ≤ jobs.size() ≤ 105
1 ≤ jobs[i][0] < jobs[i][1] ≤ 109
1 ≤ jobs[i][2] ≤ 104'

Input: jobs[][] =  [[1, 3, 60], 
                 [2, 5, 50],
                 [4, 6, 70],
                 [5, 7, 30]] 
Output: 130
Explanation: The first and third jobs with the time range [1, 3] and [4, 6] can be chosen to give maximum profit of 60 + 70 = 130.
'''
   def maxProfit(self, jobs):
        from bisect import bisect_right
        n = len(jobs)
        jobs.sort(key=lambda j: (j[1], j[0]))
        dp = [0] * n
        dp[0] = jobs[0][2]
        for i in range(1, n):
            start, end, profit = jobs[i]
            j = bisect_right(jobs, start, key=lambda x: x[1])
            if j > 0:
                profit += dp[j - 1]
            dp[i] = max(dp[i - 1], profit)
        return dp[-1]

# Sort jobs by end time
# DP array: dp[i] = max profit till i-th job
# Find the last job that doesn't overlap (using binary search)
#If a compatible previous job exists: Add its best profit (dp[j-1]) to the current job’s profit.
# max(Skip current job (dp[i-1]),  Take current job (profit + dp[j])) 
