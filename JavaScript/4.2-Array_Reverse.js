let myArray = ["A", "B", "C"];

function reverseArray(myArray) {
    let newArray = [];
    while (myArray.length > 0) {
        item = myArray.pop();
        newArray.push(item);
    } return newArray;
} 

console.log(reverseArray(myArray))
