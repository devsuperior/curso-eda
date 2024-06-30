const containsDuplicate = (nums) => {
    let isDuplicate = false;
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j])
                return !isDuplicate;
        }
    }

    return isDuplicate;
};

let nums = [1,1,1,3,3,4,3,2,4,2];
console.log(`Array [${nums}] contém valores duplicados? ${containsDuplicate(nums)}`);

nums = [1,2,3,4,5,10,9,8,7,6];
console.log(`Array [${nums}] contém valores duplicados? ${containsDuplicate(nums)}`);
