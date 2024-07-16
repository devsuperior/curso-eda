class Rank {
  constructor(word, count) {
    this.word = word;
    this.count = count;
  }
}

function wordCount(text) {
  const dict = new Map();
  const words = normalize(text).split(" ");

  for (let word of words) {
    if (!dict.has(word)) {
      dict.set(word, 1);
    } else {
      dict.set(word, dict.get(word) + 1);
    }
  }

  const ranks = [];
  for (let [word, count] of dict) {
    ranks.push(new Rank(word, count));
  }

  ranks.sort((a, b) => {
    const countComparison = b.count - a.count;
    if (countComparison !== 0) {
      return countComparison;
    }
    return a.word.localeCompare(b.word);
  });

  return ranks;
}

function normalize(text) {
  const words = text.replace(/[^\p{L}\p{N}\s]/gu, " ");
  return words.replace(/\s+/g, " ").trim().toLowerCase();
}

const inputText = `
  O vento sussurra sons entre as árvores, sons que fazem animais 
  correrem. A floresta e a natureza vibram com segredos e sons.
`;

const result = wordCount(inputText);
result.forEach((obj) => {
  console.log(obj.word + ": " + obj.count);
});
