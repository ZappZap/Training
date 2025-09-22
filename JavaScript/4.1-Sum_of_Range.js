// Sum of Range
// Takes two arguments and returns their summary after creating a range of the given arguements 

function range(start,end,step) {
  let arr = []
  stepTrue = Math.abs(step)
  if (stepTrue == undefined) {
    for (let i = start; i <= end; i++) {
      arr.push(i);
    }
  } else {
    for (let i = start; i <= end; i += stepTrue) {
      arr.push(i);
    }
  } return arr;
}

function sum(arr) {
  let suma = 0;
  for (let i = 0; i < arr.length; i += 2) {
    if (i + 1 < arr.length) {
      suma += arr[i] + arr[i + 1];
    } else {
      suma += arr[i];
    }
  } return suma;
}


console.log(sum(range(1,10,-2)))
