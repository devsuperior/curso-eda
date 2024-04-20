class Solution:
    def findContentChildren(self, g, s):
        g.sort()
        s.sort()

        j, ans = 0, 0
        # Para cada criança
        for i in range(len(g)):
            # Tenta encontrar um cookie que se encaixe
            while j < len(s) and s[j] < g[i]:
                j += 1
            # Se não houver mais cookies
            if j == len(s):
                break
            else:
                ans += 1
                j += 1

        return ans
    
s = Solution()
print(s.findContentChildren([1, 2, 3], [1, 1]))
print(s.findContentChildren([1, 2], [2, 3, 1]))