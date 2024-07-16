function counting(votes) {
  const dict = new Map();

  votes.forEach(s => {
      const [name, count] = s.split(",");
      const countInt = Number(count);
      if (!dict.has(name)) {
        dict.set(name, countInt);
      }
      else {
        dict.set(name, dict.get(name) + countInt);
      }
  });

  const result = [];
  for (const [key, value] of dict) {
      result.push(`${key},${value}`);
  }

  return result;
}

const input = [
  "Alex Blue,15",
  "Maria Green,22",
  "Bob Brown,21",
  "Alex Blue,30",
  "Bob Brown,15",
  "Maria Green,27",
  "Maria Green,22",
  "Bob Brown,25",
  "Alex Blue,31"
];

const result = counting(input);
result.forEach(s => console.log(s));
