function validatePassword(str) {
    if (str.length < 8) {
        return false;
    }
    if (!hasLetter(str)) {
        return false;
    }
    if (!hasDigit(str)) {
        return false;
    }
    if (!hasSpecialChar(str)) {
        return false;
    }
    return true;
}

function hasLetter(str) {
    for (let i = 0; i < str.length; i++) {
        if ((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z')) {
            return true;
        }
    }
    return false;
}

function hasDigit(str) {
    for (let i = 0; i < str.length; i++) {
        if (str[i] >= '0' && str[i] <= '9') {
            return true;
        }
    }
    return false;
}

function hasSpecialChar(str) {
    for (let i = 0; i < str.length; i++) {
        if (str[i] === '@' || str[i] === '#' || str[i] === '&') {
            return true;
        }
    }
    return false;
}

function validatePassword2(str) {
    const regex1 = /.{8,}/;
    const regex2 = /[a-zA-Z]/;
    const regex3 = /\d/;
    const regex4 = /[@$#]/;
    return regex1.test(str) && regex2.test(str) && regex3.test(str) && regex4.test(str);
}

/* Prompt para ChatGPT:
Me dê uma regex Javascript que valide se um string atende às seguintes condições: 
1. Deve ter no mínimo 8 caracteres 
2. Deve ter no mínimo 1 letra maiúscula ou minúscula 
3. Deve ter no mínimo 1 dígito 
4. Deve ter no mínimo 1 dos seguintes caracteres especiais: @ & #

/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@&#]).{8,}$/
*/

function validatePassword3(str) {
    const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@&#]).{8,}$/;
    return regex.test(str);
}

console.log(validatePassword("amerca1@"));
console.log(validatePassword("amrca154682"));
console.log(validatePassword2("amerca1@"));
console.log(validatePassword2("amrca154682"));
console.log(validatePassword3("amerca1@"));
console.log(validatePassword3("amrca154682"));
