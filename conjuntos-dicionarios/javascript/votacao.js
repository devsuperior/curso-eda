function counting(votes) {
  const dict = {};

  votes.forEach(s => {
      const [name, count] = s.split(",");
      const countInt = parseInt(count, 10);
      if (!dict.hasOwnProperty(name)) {
        dict[name] = countInt;
      }
      else {
        dict[name] += countInt;
      }
  });

  const result = [];
  for (const [key, value] of Object.entries(dict)) {
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
