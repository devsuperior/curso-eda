class Solution:
    def maximumBottles(self, n, x, v):
        v.sort()

        ans = 0
        for i in range(n):
            # Se houver água suficiente para encher uma garrafa completamente
            if x - v[i] >= 0:
                x -= v[i]
                ans += 1
            else:
                break
        return ans
    
s = Solution()
print(s.maximumBottles(5, 10, [8, 5, 4, 3, 2]))
print(s.maximumBottles(3, 10, [6, 3, 2]))