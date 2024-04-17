#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        map<int, int> myBills;
        myBills[5] = 0;
        myBills[10] = 0;
        myBills[20] = 0;

        for (int bill : bills) {
            // Adiciona a nota recebida ao nosso controle
            myBills[bill]++;

            int change = bill - 5;

            // Tentativas de dar o troco, começando com cédulas de maior valor
            vector<int> values = {20, 10, 5};
            for (int value : values) {
                while (change >= value && myBills[value] > 0) {
                    myBills[value]--;
                    change -= value;
                }
            }

            // Se após tentar dar o troco ainda resta valor, retorna false
            if (change > 0) {
                return false;
            }
        }

        // Se foi possível dar o troco em todos os casos, retorna true
        return true;
    }
};

int main(){
    Solution s;
    vector<int> input{5, 5, 5, 10, 20};

    if(s.lemonadeChange(input)) cout << "true\n";
    else cout << "false\n";
}