class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
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