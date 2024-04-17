def minimum_coins(n, heads, m, knights):
    heads.sort()
    knights.sort()

    k = 0
    coins = 0
    saved = True
    for i in range(n):
        # Seleciona cavaleiro k para cortar cabeça i
        while k < m and knights[k] < heads[i]:
            k += 1
        
        if k < m:
            coins += knights[k]
            k += 1
        else:
            saved = False
            break

    if not saved:
        return -1
    else:
        return coins