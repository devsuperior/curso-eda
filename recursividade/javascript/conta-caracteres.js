function charCount(ch, text) {
  return charCountTailRecursive(ch.toLowerCase(), text.toLowerCase(), 0, 0);
}

function charCountTailRecursive(ch, text, index, count) {
  if (index >= text.length) {
    return count;
  }

  const newCount = (text[index] == ch) ? count + 1 : count;

  return charCountTailRecursive(ch, text, index + 1, newCount);
}

const result = charCount("b", "Batata para o bebê");
console.log(result);
