function isPalindrome(text) {
  return isPalindromeTailRecursive(text, 0, text.length - 1);
}

function isPalindromeTailRecursive(text, start, end) {
  if (start >= end) {
    return true;
  }

  if (text[start] !== text[end]) {
    return false;
  }

  return isPalindromeTailRecursive(text, start + 1, end - 1);
}

console.log(isPalindrome(""));
console.log(isPalindrome("aba"));
console.log(isPalindrome("abccba"));
console.log(isPalindrome("abcfba"));
