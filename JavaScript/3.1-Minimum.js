// Minimum
// Given an array of integers, find the minimum value in the array.

function findMinimum(a,b) {
    if (a < b) {
        return a;
    } else {
        return b;
    }
}

console.log(findMinimum(0, -10)); // -10