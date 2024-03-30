function removeNonDigits(str) {
    let charArray = []; 

    for (let i = 0; i < str.length; i++) {
        if (str[i] >= '0' && str[i] <= '9') {
            charArray.push(str[i]);
        }
    }

    return charArray.join("");
}


function removeNonDigits2(str) {
    const regex = /\D/g;
    return str.replace(regex, "");
}


console.log(removeNonDigits("949.237.847-99"));
console.log(removeNonDigits2("949.237.847-99"));
