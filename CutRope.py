'''Given a rope of length n meters, cut it into multiple smaller ropes such that the product of their lengths is maximized. At least one cut is mandatory.

Constraints:
2 ≤ n ≤ 58

Input: n = 2
Output: 1

Input: n = 5
Output: 6
'''
class Solution:
    def maxProduct(self, n):
        # code
        rem3=n%3
        cou=n//3
        if n==2: return 1
        if n==3: return 2
        if rem3==0:
            return 3**cou
        elif rem3==1:
            return 3**(cou-1)*4
        else:
            return 3**cou*2
        
