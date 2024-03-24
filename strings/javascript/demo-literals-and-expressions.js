const name = "Alice";
const age = 31;
const points = 8.347;

// Simple literal
const str1 = "Olá, mundo!";
const str1_2 = "Olá mundo!";
const str1_3 = `Olá mundo!`;
console.log("str1:");
console.log(str1);

// Concatenation
const str2 = "Cliente " + name + " tem idade " + age + " anos e fez " + points + " pontos.";
console.log("str2:");
console.log(str2);

// Escape characters
const str3 = "Cliente: " + name + "\nIdade: " + age;
const str4 = "c:\\Program Files\\Windows";
const str5 = 'Senha = "carro123"';
const str5_2 = 'Senha = "carro123"';
const str6 =
  "<html>\n" +
  "\t<body>\n" +
  "\t\t<p>Hello, World!</p>\n" +
  "\t</body>\n" +
  "</html>\n";
console.log("str3:");
console.log(str3);
console.log("str4:");
console.log(str4);
console.log("str5:");
console.log(str5);
console.log("str6:");
console.log(str6);

// Template literals (interpolation)
const str7 = `Cliente ${name} tem idade ${age} anos e fez ${points} pontos.`;
const str8 = 
`<html>
    <body>
        <p>Hello, World!</p>
    </body>
</html>
`;
const str9 = 
`<html>
    <body>
        <p>Hello, World ${name}!</p>
    </body>
</html>
`;
console.log("str7:");
console.log(str7);
console.log("str8:");
console.log(str8);
console.log("str9:");
console.log(str9);

// Number format
const str10 = `Cliente ${name} tem idade ${age} anos e fez ${points.toFixed(2)} pontos.`;
console.log("str10:");
console.log(str10);
