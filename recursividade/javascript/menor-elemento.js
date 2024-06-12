function minor(list) {
  if (list.length === 1) {
    return list[0];
  }

  const head = list[0];
  const tail = list.slice(1);

  const tailMinor = minor(tail);

  return (head < tailMinor) ? head : tailMinor;
}

const result = minor([10, 15, 20, 8, 30, 17]);
console.log("MENOR = " + result);
