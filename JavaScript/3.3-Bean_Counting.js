// Bean Counting

function countBs(text) {
    let result = 0;
    for (i= 0; i <= text.length; i++) {
        if (text[i] === "B")
            result++;
    }
    return result;
}

function countChar(text, letter) {
    let result = 0;
    for (i= 0; i <= text.length; i++) {
        if (text[i] === letter)
            result++;
    }
    return result;
}

console.log(countBs("BOB")); // 2
console.log(countChar("kakkerlak", "k")); // 4