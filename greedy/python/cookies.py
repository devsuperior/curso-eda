class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
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