let str1 = "Hello, ";
let str2 = "World!";
let str3 = "This is a test. Testing, test one, two, three.";
let str4 = "Mozilla";

console.log(`str1: "${str1}"`);
console.log(`str2: "${str2}"`);
console.log(`str3: "${str3}"`);
console.log(`str4: "${str4}"`);

// concat()
let concatenated = str1.concat(str2);
console.log("str1.concat(str2):", concatenated);

// indexOf()
console.log("str3.indexOf('Test'):", str3.indexOf("Test"));

// lastIndexOf()
console.log("str3.lastIndexOf('test'):", str3.lastIndexOf("test"));

// match()
console.log("str3.match('test'):", str3.match("test"));

// match() (a flag /g indica busca global, ou seja, não para na primeira ocorrência)
console.log("str3.match(/test/g):", str3.match(/test/g));

// matchAll()
let matchAllResult1 = Array.from(str3.matchAll("test"));
console.log("Array.from(str3.matchAll('test')):", matchAllResult1);

// matchAll() (a flag /g indica busca global, ou seja, não para na primeira ocorrência)
let matchAllResult2 = Array.from(str3.matchAll(/test/g));
console.log("Array.from(str3.matchAll(/test/g)):", matchAllResult2);

// replace()
console.log("str3.replace('test', 'demo'):", str3.replace("test", "demo"));

// replaceAll()
console.log("str3.replaceAll('test', 'demo'):", str3.replaceAll("test", "demo"));

// search()
console.log("str3.search('test'):", str3.search("test"));

// split()
console.log("str3.split(' '):", str3.split(" "));

// slice()
console.log("str4.slice(-3):", `"${str4.slice(-3)}"`);    // "lla"
console.log("str4.slice(2, 5):", `"${str4.slice(2, 5)}"`);  // "zil"
console.log("str4.slice(5, 2):", `"${str4.slice(5, 2)}"`);  // ""

// substring()
console.log("str4.substring(-3):", `"${str4.substring(-3)}"`);  // "Mozilla" (índices negativos tornam-se 0)
console.log("str4.substring(2, 5):", `"${str4.substring(2, 5)}"`); // "zil"
console.log("str4.substring(5, 2):", `"${str4.substring(5, 2)}"`); // "zil" (índices são invertidos)

// toLowerCase()
console.log("str2.toLowerCase():", str2.toLowerCase());

// toUpperCase()
console.log("str1.toUpperCase():", str1.toUpperCase());

// trim()
console.log('"    Hello World!    ".trim():', `"${'    Hello World!    '.trim()}"`);

// trimStart()
console.log('"    Hello World!    ".trimStart():', `"${'    Hello World!    '.trimStart()}"`);

// trimEnd()
console.log('"    Hello World!    ".trimEnd():', `"${'    Hello World!    '.trimEnd()}"`);

// charAt()
console.log("str2.charAt(1):", str2.charAt(1));

// charCodeAt()
console.log("str2.charCodeAt(1):", str2.charCodeAt(1));

// startsWith()
console.log("str2.startsWith('Wor'):", str2.startsWith("Wor"));

// endsWith()
console.log("str2.endsWith('!'):", str2.endsWith("!"));

// includes()
console.log("str3.includes('test'):", str3.includes("test"));

// padStart()
console.log("'5'.padStart(3, '0'):", "5".padStart(3, "0"));
console.log("'52'.padStart(3, '0'):", "52".padStart(3, "0"));

// padEnd()
console.log("'5'.padEnd(3, '0'):", "5".padEnd(3, "0"));
console.log("'52'.padEnd(3, '0'):", "52".padEnd(3, "0"));
