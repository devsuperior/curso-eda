def maximum_reward(tasks):
    # Ordena as tarefas por duração e prazo
    tasks.sort()

    reward = 0
    time = 0
    for duration, deadline in tasks:
        time += duration
        reward += (deadline - time)

    return reward