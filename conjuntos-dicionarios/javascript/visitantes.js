import { visitors } from "./visitantes-input.js";

function total(visitors) {
  const uniqueVisitors = new Set();

  visitors.forEach((visitor) => {
    const name = visitor.split(",")[0];
    uniqueVisitors.add(name);
  });

  return uniqueVisitors.size;
}

function totalNaive(visitors) {
  const uniqueVisitors = [];

  visitors.forEach((visitor) => {
    const name = visitor.split(",")[0];
    if (!uniqueVisitors.includes(name)) {
      uniqueVisitors.push(name);
    }
  });

  return uniqueVisitors.length;
}

const start1 = new Date();
const result1 = total(visitors);
const end1 = new Date();
const time1 = (end1 - start1) / 1000;
console.log(`RESULT = ${result1}. Time = ${time1.toFixed(3)}s`);

const start2 = new Date();
const result2 = totalNaive(visitors);
const end2 = new Date();
const time2 = (end2 - start2) / 1000;
console.log(`RESULT = ${result2}. Time = ${time2.toFixed(3)}s`);

const quo = time2 / time1;
console.log(`Segundo algoritmo ${quo.toFixed(1)} vezes mais lento`);
