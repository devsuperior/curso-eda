function sumList(list) {
  if (list.length === 0) {
    return 0;
  }

  const head = list[0];
  const tail = list.slice(1);

  return head + sumList(tail);
}

const result = sumList([4, 5, 3]);
console.log("RESULTADO = " + result);
