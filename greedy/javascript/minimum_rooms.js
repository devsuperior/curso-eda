/**
 * @param {number[]} start
 * @param {number[]} end
 * @param {number} n
 * @returns {number}
*/
var minimumRooms = function(start, end, n){
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

start = [900, 940, 950, 1100, 1500, 1800]
end = [910, 1200, 1120, 1130, 1900, 2000]
console.log(minimumRooms(start, end, 6))

start = [900, 1100, 1235]
end = [1000, 1200, 1240]
console.log(minimumRooms(start, end, 3))
