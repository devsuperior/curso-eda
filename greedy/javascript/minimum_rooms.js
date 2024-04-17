/**
 * @param {number[]} start
 * @param {number[]} end
 * @param {number} n
 * @returns {number}
*/
class Solution {
    minimumRooms(start, end, n)
    {
        start.sort((a, b) => a - b);
        end.sort((a, b) => a - b);
    	
        let i = 0, j = 0, ans = 0, rooms = 0;
        
    	// allocate rooms as need them, and keep the maximum we needed
    	while (i < n || j < n) {
    	    if(start[i] <= end[j]) {
    	        i++;
    	        rooms++;
    	    }
    	    else{
    	        j++;
    	        rooms--;
    	    }
    	    
    	    ans = Math.max(ans, rooms);
    	}
    	
    	return ans;
    }
}