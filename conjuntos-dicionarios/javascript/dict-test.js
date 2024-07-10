let cookies = {};

cookies["user"] = "maria34";
cookies["email"] = "ana@gmail.com";
cookies["email"] = "maria@gmail.com";
cookies["last-login"] = "2024-07-04T21:42:40.353283800Z";

console.log("Values:");
for (let value of Object.values(cookies)) {
    console.log(value);
}

console.log("Keys & values:");
for (let key in cookies) {
    console.log(key + ": " + cookies[key]);
}

console.log("Is empty: " + (Object.keys(cookies).length === 0));
console.log("Size: " + Object.keys(cookies).length);

console.log("Contains 'email': " + cookies.hasOwnProperty("email"));
console.log("Contains 'email': " + ("email" in cookies));
let removed = cookies["email"];
console.log("Remove: " + removed);
delete cookies["email"];

console.log("Contains 'email': " + cookies.hasOwnProperty("email"));
console.log("Contains 'email': " + ("email" in cookies));
removed = cookies["email"];
console.log("Remove: " + removed);
