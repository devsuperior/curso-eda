class Solution:
    def maximum_reward(self, tasks):
        # Ordena as tarefas por duração e prazo
        tasks.sort()

        reward = 0
        time = 0
        for duration, deadline in tasks:
            time += duration
            reward += (deadline - time)

        return reward

s = Solution()
input1 = [[6, 10],
          [8, 15],
          [5, 12]]
print(s.maximum_reward(input1))

input2 = [[3, 47],
          [5, 11],
          [1, 70],
          [2, 100],
          [2, 41],
          [2, 66],
          [5, 80],
          [4, 84],
          [5, 81],
          [5, 40]]
print(s.maximum_reward(input2))

input3 = [[80, 55],
          [29, 46],
          [58, 5],
          [92, 80],
          [62, 68],
          [64, 20],
          [78, 56],
          [41, 66],
          [62, 44],
          [32, 80]]
print(s.maximum_reward(input3))