class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # Mapeia a quantidade de cédulas de cada valor que temos
        my_bills = {5: 0, 10: 0, 20: 0}

        for bill in bills:
            my_bills[bill] += 1

            change = bill - 5

            # Tentativas de dar o troco, começando com cédulas de maior valor
            for value in (20, 10, 5):
                while change >= value and my_bills[value] > 0:
                    my_bills[value] -= 1
                    change -= value

            if change > 0:
                return False

        return True