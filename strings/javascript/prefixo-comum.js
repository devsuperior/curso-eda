function longestCommonPrefix(v) {
  v.sort();
  let first = v[0];
  let last = v[v.length - 1];
  let result = [];

  for (let i = 0; i < Math.min(first.length, last.length); i++) {
    if (first[i] !== last[i]) {
      return result.join("");
    }
    result.push(first[i]);
  }

  return result.join("");
}

console.log(`"${longestCommonPrefix(["flower", "flow", "flight"])}"`);
console.log(`"${longestCommonPrefix(["dog", "racecar", "car"])}"`);
