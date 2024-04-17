/**
 * @param {number[]} arr
 * @param {number} n
 * @param {number} k
 * @returns {number}
*/
var catchThieves = function(arr, n, k)
{
    let thieves_index = [], police_index = [];
    
    // get the indices for thieves and police
    for(let i = 0; i < n; i++){
        if(arr[i] == 'T')
            thieves_index.push(i);
        else if(arr[i] == 'P')
            police_index.push(i);
    }
    
    let t = 0, p = 0, ans = 0;
    // while there's thieves or police left
    while(t < thieves_index.length && p < police_index.length){
        
        let dist = Math.abs(thieves_index[t] - police_index[p]);
        if(dist <= k) {
            ans++;
            t++;
            p++;
        }
        else if(thieves_index[t] < police_index[p]){
            t++;
        }
        else{
            p++;
        }
    }
    
    return ans;
}