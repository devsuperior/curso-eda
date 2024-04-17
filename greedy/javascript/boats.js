/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    let l = 0, r = people.length - 1;

    people.sort((a, b) => a- b);

    let boats = 0;
    while(l <= r) {
        // fit two people in one boat
        if(people[r] + people[l] <= limit){
            l++;
            r--;
        }
        // only fit the heaviest
        else if(people[r] <= limit){
            r--;
        }
        else{
            l++;
        }
        boats++;
    }

    return boats;  
};