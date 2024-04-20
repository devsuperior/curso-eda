class Solution:
    def catchThieves(self, arr, n, k): 
        thieves_index = []
        police_index = []
        
        # Obtém os índices para ladrões e policiais
        for i in range(n):
            if arr[i] == 'T':
                thieves_index.append(i)
            elif arr[i] == 'P':
                police_index.append(i)
        
        t = 0
        p = 0
        ans = 0
        # Enquanto houver ladrões ou policiais restantes
        while t < len(thieves_index) and p < len(police_index):
            
            dist = abs(thieves_index[t] - police_index[p])
            if dist <= k:
                ans += 1
                t += 1
                p += 1
            elif thieves_index[t] < police_index[p]:
                t += 1
            else:
                p += 1
        
        return ans
    
s = Solution()
print(s.catchThieves(['P', 'T', 'T', 'P', 'T'], 5, 1))
print(s.catchThieves(['T', 'T', 'P', 'P', 'T', 'P'], 6, 2))