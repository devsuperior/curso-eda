class Solution:
    def findLargest(self, N, S):
        ans = ""

        # Se mesmo com os dígitos máximos não conseguimos fazer S
        if 9 * N < S or (S == 0 and N > 1):
            return "-1"

        while S > 0:
            # De forma gulosa, encaixamos o máximo de dígitos '9' que conseguirmos
            if S - 9 >= 0:
                S -= 9
                digit = '9'
            # Encaixamos o resto da soma
            else:
                digit = str(S)
                S = 0
            ans += digit

        # Completamos até alcançar N dígitos, se necessário
        while len(ans) < N:
            ans += '0'

        return ans