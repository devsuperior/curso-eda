function extractEmailInformation(email) {
  const parts = email.split("@");
  const username = parts[0];
  const domain = parts[1];

  const isBrazilian = domain.endsWith(".br");

  return { username, domain, isBrazilian };
}

const emailInfo1 = extractEmailInformation("joao.silva23@yahoo.com.br");
console.log("Usuario:", emailInfo1.username);
console.log("Dominio:", emailInfo1.domain);
console.log("Brasileiro:", emailInfo1.isBrazilian ? "sim" : "nao");

const emailInfo2 = extractEmailInformation("maria123@gmail.com");
console.log("Usuario:", emailInfo2.username);
console.log("Dominio:", emailInfo2.domain);
console.log("Brasileiro:", emailInfo2.isBrazilian ? "sim" : "nao");
