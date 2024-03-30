function formatDate(day, month, year) {
  let formatDay = String(day).padStart(2, "0");
  let formatMonth = String(month).padStart(2, "0");

  return `${formatDay}/${formatMonth}/${year}`;
}

console.log(formatDate(21, 7, 2010)); 
