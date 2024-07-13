let cookies = new Map();

cookies.set("user", "maria34");
cookies.set("email", "ana@gmail.com");
cookies.set("email", "maria@gmail.com"); // Sobrescreve o valor anterior
cookies.set("last-login", "2024-07-04T21:42:40.353283800Z");

console.log("Values:");
for (let value of cookies.values()) {
    console.log(value);
}

console.log("Keys & values:");
for (let [key, value] of cookies) {
    console.log(key + ": " + value);
}

console.log("Is empty: " + (cookies.size === 0));
console.log("Size: " + cookies.size);

console.log("Contains 'email': " + cookies.has("email"));
let removed = cookies.get("email");
console.log("Remove: " + removed);
cookies.delete("email");

console.log("Contains 'email': " + cookies.has("email"));
removed = cookies.get("email");
console.log("Remove: " + removed);
