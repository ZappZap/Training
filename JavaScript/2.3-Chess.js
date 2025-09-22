// Chessboard
// The chessboard is a classic programming exercise. The goal is to create a text-based representation of a chessboard using "#" and " " characters.

let heightUser = 15
let lengthUser = 20


for (height = 1; height <= heightUser; height++) {
    if (height % 2 == 0) {
        console.log(outputOddF());
    } else console.log(outputEvenF());
}

function outputOddF() {
    for (outputOdd = ""; outputOdd.length <= lengthUser;) {
        if (outputOdd.length % 2 == 0) {
            outputOdd = outputOdd + "#";
        } else {
            outputOdd = outputOdd + " ";
        }
    }
    return outputOdd
}
    
function outputEvenF() {
    for (outputEven = ""; outputEven.length <= lengthUser;) {
        if (outputEven.length % 2 != 0) {
            outputEven = outputEven + "#";
        } else {
            outputEven = outputEven + " ";
        }
    }
    return outputEven;
}
    
console.log(outputOdd + "\n" + outputEven)