def findJudge(n, trust):
    # Vetor para contar quantas pessoas confiam em cada pessoa
    trustCount = [0] * (n + 1)
    # Vetor para verificar se uma pessoa confia em alguém
    trustsSomeone = [False] * (n + 1)

    # Processa a lista de confiança
    for a, b in trust:
        # Marca que a pessoa 'a' confia em alguém
        trustsSomeone[a] = True
        # Incrementa o contador de confiança para a pessoa 'b'
        trustCount[b] += 1

    # Verifica cada pessoa para encontrar o juiz
    for i in range(1, n + 1):
        # O juiz não confia em ninguém e todos (exceto ele mesmo) confiam nele
        if trustCount[i] == n - 1 and not trustsSomeone[i]:
            return i

    # Se não encontrar nenhum juiz, retorna -1
    return -1

# Exemplo 1
n = 2
trust = [[1, 2]]
print(findJudge(n, trust))

# Exemplo 2
n = 3
trust = [[1, 3], [2, 3]]
print(findJudge(n, trust))

# Exemplo 3
n = 3
trust = [[1, 3], [2, 3], [3, 1]]
print(findJudge(n, trust))
