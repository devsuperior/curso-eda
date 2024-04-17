/**
 * @param {number} n
 * @param {number[]} heads
 * @param {number} m
 * @param {number[]} knights
 * @return {boolean}
 */
var minimumCoins = function(n, heads, m, knights) {
    heads.sort((a, b) => a - b);
    knights.sort((a, b) => a - b);

    let k = 0, coins = 0;
    let saved = true;
    for(let i = 0; i < n; i++){
        // seleciona cavaleiro k para cortar cabeca i
        while(knights[k] < heads[i] && k < m){
            k++;
        }

        coins += knights[k];
        
        if(k < m) k++;
        else{
            saved = false;
            break;
        }
    }

    if(!saved) return -1;
    else return coins;
};