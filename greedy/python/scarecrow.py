class Solution:
    def minimumScarecrows(self, n, field):
        ans = 0
        i = 0
        while i < n:
            if field[i] == '.':
                i += 3
                ans += 1
            else:
                i += 1
        return ans
    
s = Solution()
print(s.minimumScarecrows(3, '.#.'))
print(s.minimumScarecrows(11, '...##....##'))
print(s.minimumScarecrows(2, '##'))