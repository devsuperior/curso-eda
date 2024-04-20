class Solution:
    def minimum_rooms(self, start, end, n):
        start.sort()
        end.sort()

        i = 0
        j = 0
        ans = 0
        rooms = 0

        # Aloca salas conforme necessário e mantém o máximo que precisamos
        while i < n or j < n:
            if i < n and (j == n or start[i] <= end[j]):
                i += 1
                rooms += 1
            else:
                j += 1
                rooms -= 1

            ans = max(ans, rooms)

        return ans

s = Solution()

start = [900, 940, 950, 1100, 1500, 1800]
end = [910, 1200, 1120, 1130, 1900, 2000]
print(s.minimum_rooms(start, end, 6))

start = [900, 1100, 1235]
end = [1000, 1200, 1240]
print(s.minimum_rooms(start, end, 3))
