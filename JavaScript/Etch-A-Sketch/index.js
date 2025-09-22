// GRID INPUT BUTTONS \\
    let columns;
    let rows;

    document.getElementById("columnSubmit").onclick = function() {
        columns = document.getElementById("columnsUser").value;
        console.log(columns)
    }

    document.getElementById("rowsSubmit").onclick = function() {
        rows = document.getElementById("rowsUser").value;
        console.log(rows)
    }

    document.getElementById("gridButton").onclick = makeGrid(rows,columns)

// GRID \\
function makeGrid(rows, columns) {
    const grid = document.getElementById("bodyGrid")
    cells = 0;
    for (let i = 0; i < (rows * columns); i++) {
        cells = document.createElement("div")
        cells.innerText = (i + 1);
        grid.appendChild(cells).className = "grid-item";
}}
