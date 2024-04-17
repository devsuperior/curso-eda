/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g.sort((a, b) => a - b);
    s.sort((a, b) => a - b);

    let j = 0, ans = 0;
    
    // for each child
    for(let i = 0; i < g.length; i++) {
        // try to find a cookie that fits
        while(j < s.length && s[j] < g[i]){
            j++;
        }
        // if there's no more cookies
        if(j == s.length)
            break;
        else {
            ans++;
            j++;
        }
    }

    return ans;
};