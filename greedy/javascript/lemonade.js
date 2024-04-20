/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let myBills = { 5: 0, 10: 0, 20: 0 };

    for (let i = 0; i < bills.length; i++) {
        const bill = bills[i];
        myBills[bill]++;

        let change = bill - 5;

        // Tentativas de dar o troco, começando com cédulas de maior valor
        [20, 10, 5].forEach(value => {
            while (change >= value && myBills[value] > 0) {
                myBills[value]--;
                change -= value;
            }
        });

        // Se após tentar dar o troco ainda resta valor, retorna false
        if (change > 0) {
            return false;
        }
    }

    // Se foi possível dar o troco em todos os casos, retorna true
    return true;
};

if(lemonadeChange([5, 5, 5, 10, 20]))
    console.log("Verdadeiro")
else
    console.log("Falso")

if(lemonadeChange([5, 5, 10, 10, 20]))
    console.log("Verdadeiro")
else
    console.log("Falso")