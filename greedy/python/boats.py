class Solution:
    def numRescueBoats(self, people, limit):
        people.sort()
        l, r = 0, len(people) - 1

        boats = 0
        while l <= r:
            # tenta encaixar duas pessoas no mesmo bote
            if people[r] + people[l] <= limit:
                l += 1
                r -= 1
            # caso contrário, coloca apenas a pessoa mais pesada no bote
            elif people[r] <= limit:
                r -= 1
            else:
                l += 1
            boats += 1

        return boats
    
s = Solution()
print(s.numRescueBoats([1, 2], 3))
print(s.numRescueBoats([3, 2, 2, 1], 3))
print(s.numRescueBoats([3, 5, 3, 4], 5))